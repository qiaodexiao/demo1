package com.at.ct.web.test;

public class Test
{
    public static void main(String[] args)
    {
        String variable_json = "{\"DAY\":\"5\",\"DAYEND\":\"6\",\"MONTH\":\"2\",\"MONTHEND\":\"2\",\"OWEFEE\":\"100.00\",\"YEAR\":\"2021\", \"OTHERS\":\"其中:月固定费6.01;其他消费3232元\"}";

        String model_content = "温馨提示:截至%YEAR%年%MONTH%月%DAY%日,色地方%OWEFEE%元,请与%MONTHEND%月%DAYEND%日,sdfsfdAPP,df%OTHERS%,http://u.10010.cn/qAaqw。";

        String variable_collect = "DAY,DAYEND,MONTH,MONTHEND,OWEFEE,YEAR,OTHERS";

        String variable_json1 = "{\"YEAR\":\"2021\",\"MONTH\":\"3\",\"SERIAL_NUMBER\":\"13007712096\",\"LAST_DAY\":\"31\",\"BILLFEE\":\"49\",\"OTHERS\":\"\"}";
        String model_content1 = "账单提醒】尊敬的客户%SERIAL_NUMBER%，请查收您%YEAR%年%MONTH%月份话费账单，共产生费用合计：%BILLFEE%元，主要包括：%OTHERS%■■查询详情请点击： http://u.10010.cn/tAE3W 。回复TDZD退订本短信。【中国联通】  ";
        String variable_collect1 = "YEAR,MONTH,SERIAL_NUMBER,LAST_DAY,BILLFEE,OTHERS";

        System.out.println(new Hudf().evaluate(variable_json, variable_collect, model_content));
        System.out.println(new Udf().evaluate(variable_json1, variable_collect1, model_content1));
    }
}