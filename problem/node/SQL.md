==1、一笔订单下有多笔支付流水，这些支付流水单存在订单金额不一致的支付流水数据。== 

SELECT * FROM CDPS_INF_PYMNT P 

​	WHERE EXISTS (

​		SELECT 1 FROM CDPS_INF_PYMNT PY 

​			WHERE P.ORDER_ID = PY.ORDER_ID  **--ORDER_ID:订单id** 

​				AND P.ORDER_AMT != PY.ORDER_AMT **--ORDER_AMT:订单金额** 

​	);