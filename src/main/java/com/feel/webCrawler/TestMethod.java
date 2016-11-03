package com.feel.webCrawler; /**
 * Created by admin-pc on 2016/11/3.
 */

import java.util.List;

public class TestMethod
{

    public static void main(String[]args){
        TestMethod t=new TestMethod();
        t.getDatasByClass();
    }

    public void getDatasByClass()
    {
        Rule rule = new Rule(
                "http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",
                new String[] { "query.enterprisename","query.registationnumber" }, new String[] { "兴网","" },
                "cont_right", Rule.CLASS, Rule.POST);
        List<LinkTypeData> extracts = ExtractService.extract(rule);
        printf(extracts);
    }


    public void getDatasByCssQuery()
    {
        Rule rule = new Rule("http://www.11315.com/search",
                new String[] { "name" }, new String[] { "兴网" },
                "div.g-mn div.con-model", Rule.SELECTION, Rule.GET);
        List<LinkTypeData> extracts = ExtractService.extract(rule);
        printf(extracts);
    }

    public void printf(List<LinkTypeData> datas)
    {
        for (LinkTypeData data : datas)
        {
            System.out.println(data.getLinkText());
            System.out.println(data.getLinkHref());
            System.out.println("***********************************");
        }

    }
}