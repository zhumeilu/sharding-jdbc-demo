package com.zml.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/11/9
 * Time: 15:57
 */
public class MemberSingleKeyTableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Date> {


    /**
     * sql between 规则
     */
//    public Collection<String> doBetweenSharding(Collection<String> tableNames, ShardingValue<Long> shardingValue) {
//        Collection<String> result = new LinkedHashSet<String>(tableNames.size());
//        Range<Long> range = (Range<Long>) shardingValue.getValueRange();
//        for (long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
//            Long modValue = i % 100;
//            String modStr = modValue < 10 ? "0" + modValue : modValue.toString();
//            for (String each : tableNames) {
//                if (each.endsWith(modStr)) {
//                    result.add(each);
//                }
//            }
//        }
//        return result;
//    }

    /**
     * sql == 规则
     */
    public String doEqualSharding(Collection<String> tableNames, ShardingValue<Date> shardingValue) {
        Date modValue = shardingValue.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyM");
        String format = sdf.format(modValue);
        for (String each : tableNames) {
            if (each.endsWith(format)) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Date> shardingValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyM");
        Collection<String> result = new LinkedHashSet<String>(collection.size());
        for (Date value : shardingValue.getValues()) {
            String format = sdf.format(value);
            for (String tableName : collection) {
                if (tableName.endsWith(format)) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Date> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(collection.size());

        Range<Date> range = (Range<Date>) shardingValue.getValueRange();
        Date min = range.lowerEndpoint();
        Date max = range.upperEndpoint();
        Calendar instance = Calendar.getInstance();
        instance.setTime(min);
        int minIndex = instance.get(Calendar.WEEK_OF_YEAR);
        int maxIndex = instance.get(Calendar.WEEK_OF_YEAR);
        for (int i =minIndex;i<maxIndex;i++ ){
            result.add("");
        }

//        for (long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
//            Long modValue = i % 100;
//            String modStr = modValue < 10 ? "0" + modValue : modValue.toString();
//            for (String each : collection) {
//                if (each.endsWith(modStr)) {
//                    result.add(each);
//                }
//            }
//        }
        return result;

    }

    /**
     * sql in 规则
     */
//    public Collection<String> doInSharding(Collection<String> tableNames, ShardingValue<Long> shardingValue) {
//
//        Collection<String> result = new LinkedHashSet<String>(tableNames.size());
//        for (long value : shardingValue.getValues()) {
//            Long modValue = value % 100;
//            String modStr = modValue < 10 ? "0" + modValue : modValue.toString();
//            for (String tableName : tableNames) {
//                if (tableName.endsWith(modStr)) {
//                    result.add(tableName);
//                }
//            }
//        }
//        return result;
//    }
}
