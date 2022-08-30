package com.feng.utils;

import com.jcraft.jsch.*;

import java.io.*;
import java.util.*;

/**
 * @author
 * @time 2022/8/29 11:03
 * @Description- SFTP上传下载文件
 */
public class SftpUtils {
    /**
     * 连接sftp服务器
     * @param host 主机
     * @param port 端口
     * @param username 用户名
     * @param password 密码
     */
    public ChannelSftp connect(String host, int port, String username, String password) {
        ChannelSftp sftp = null;
        Channel channel = null;
        Session sshSession = null;

        try {
            JSch jSch = new JSch();
            //jSch.getSession(username,host,port);
            sshSession = jSch.getSession(username,host,port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking","no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
        }catch (Throwable e){
            if (channel == null){
                try {
                    channel.disconnect();
                }catch (Throwable e1) {
                }
            }

            if (sshSession != null) {
                try {
                    sshSession.disconnect();
                }catch (Throwable e1){
                }
            }
        }

        return sftp;
    }

    /**
     * 关闭连接
     * @param sftp
     */
    public void disconnect(ChannelSftp sftp){
        try {
            if (null != sftp) {
                sftp.disconnect();
                if (null != sftp.getSession()) {
                    sftp.getSession().disconnect();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 指定目录下的文件是否存在
     * @param directory 文件路径
     * @param filename 文件名
     * @param sftp
     * @return
     */
    public boolean isExist(String directory,String filename,ChannelSftp sftp) {
        try {
            Vector<ChannelSftp.LsEntry> lsEntries = listFiles(directory, sftp);
            Iterator<ChannelSftp.LsEntry> iterator = lsEntries.iterator();
            while (iterator.hasNext()){
                ChannelSftp.LsEntry entry = iterator.next();
                String flName = entry.getFilename();
                if (flName.equals(filename)){
                    return true;
                }
            }
        }catch (SftpException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 列出目录下的文件
     * @param directory 文件目录
     * @param sftp
     * @return
     * @throws SftpException
     */
    public Vector<ChannelSftp.LsEntry> listFiles(String directory, ChannelSftp sftp) throws SftpException {
        return sftp.ls(directory);
    }

    /**
     * 删除文件
     * @param directory 文件目录
     * @param deleteFile 文件名
     * @param sftp
     */
    public void delete(String directory,String deleteFile,ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);

            //关闭连接
            disconnect(sftp);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件
     * @param directory 文件路径
     * @param uploadFile 文件名
     * @param sftp
     * @return
     */
    public String upload(String directory,String uploadFile,ChannelSftp sftp) {
        String successFlag = "0";
        try {
            sftp.cd(directory);
            File file = new File(uploadFile);
            sftp.put(new FileInputStream(file),file.getName());
        }catch (Exception e) {
            successFlag = "1";
            e.printStackTrace();
        }
        return successFlag;
    }

    /**
     * 下载文件
     * @param directory 下载路径
     * @param downloadFile 下载文件
     * @param saveFile 本地路径
     * @param sftp
     * @return
     */
    public String download(String directory,String downloadFile,String saveFile,ChannelSftp sftp) {
        String successFlag = "0";
        try {
            sftp.cd(directory);
            File file = new File(saveFile);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            sftp.get(downloadFile,new FileOutputStream(file));
        }catch (Exception e) {
            successFlag = "1";
            e.printStackTrace();
        }
        return successFlag;
    }

    /**
     * 读取文件
     * @param remoteFile 文件路径+ "/" +文件名
     * @param sftp
     * @return
     */
    public InputStream read(String remoteFile,ChannelSftp sftp) {
        InputStream is = null;
        try {
            is = sftp.get(remoteFile);
        }catch (SftpException e) {
            e.printStackTrace();
        }
        return is;
    }

    public long size(String directory, String fileName, ChannelSftp sftp) {
        long size = 0;
        try {
            Vector<ChannelSftp.LsEntry> lsEntries = listFiles(directory, sftp);
            Iterator<ChannelSftp.LsEntry> iterator = lsEntries.iterator();
            while (iterator.hasNext()){
                ChannelSftp.LsEntry entry = iterator.next();
                String flName = entry.getFilename();
                size = entry.getAttrs().getSize();
                if (fileName.equals(flName)) {
                    return size;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return size;
    }

    /**
     * 按行读取
     * @param stream
     * @return
     */
    public List<String> readLine(InputStream stream) {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(stream));
            String line = "";
            while ((line = reader.readLine()) != null){
                if (line.trim().length()>0){
                    list.add(line);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return list;
    }
}
