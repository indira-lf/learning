==1、一笔订单下有多笔支付流水，这些支付流水单存在订单金额不一致的支付流水数据。== 

```plsql
SELECT * FROM CDPS_INF_PYMNT P 

	WHERE EXISTS (

		SELECT 1 FROM CDPS_INF_PYMNT PY 

			WHERE P.ORDER_ID = PY.ORDER_ID  --ORDER_ID:订单id 

				AND P.ORDER_AMT != PY.ORDER_AMT --ORDER_AMT:订单金额 

	);
```

==1、查询某天日期票据基本信息表（CDPS_INF_DRFT）存在票据对账临时表（CDPS_TMP_CHECK）不存在的数据.== 

```plsql
SELECT * FROM CDPS_INF_DRFT A

	WHERE A.MODIFY_DATE = #{date,jdbcType = VARCHAR}

		AND (

				SELECT COUNT(1) FROM CDPS_TMP_CHECK B
          --支付流水号+票据包号+票据包开始区间+票据包结束区间确定一笔数据

				WHERE A.PYMNT_ID = B.PYMNT_ID --支付流水号

					AND A.BP_NO = B.BP_NO --票据包号

					AND A.CD_RANGE_START = B.CD_RANGE_START --票据包开始区间

					AND A.CD_RANGE_END = B.CD_RANGE_END --票据结束区间

					AND A.MODIFY_DATE = #{date,jdbcType = VARCHAR}

			) = 0

```







