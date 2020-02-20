package cn.sgwks.test;


import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TestFreemarker {
    public static void main(String[] args) throws Exception {
        //1. 创建模板引擎初始化对象
        Configuration conf = new Configuration();
        //2. 加载模板所在目录位置
        conf.setDirectoryForTemplateLoading(new File("D:\\Text Work\\IDEA\\WorkSpace\\freemarkerDemo\\src\\main\\resources\\ftl"));
        //3. 加载模板对象
        Template template = conf.getTemplate("test.ftl");
        //4. 模拟假数据, 这个数据是需要放入模板中的
        HashMap<String, Object> rootMap = new HashMap<>();
        /**
         * 模板获取string类型数据
         */
        rootMap.put("name", "sgw");
        rootMap.put("message", "在学习模板引擎");
        rootMap.put("success",false);

        //设置List数据
        ArrayList<String> booksList = new ArrayList<>();
        booksList.add("西游记");
        booksList.add("水浒传");
        booksList.add("三国演义");
        booksList.add("红楼梦");
        rootMap.put("booksList",booksList);
        //设置时间
        rootMap.put("today",new Date());
        //数字转换为字符串
        rootMap.put("point",102920122);
        //空值处理运算符
        //rootMap.put("aaa",102920122);

        HashMap<String, Float> booksMap = new HashMap<>();
        booksMap.put("西游记",128F);
        booksMap.put("水浒传",228F);
        booksMap.put("三国演义",328F);
        booksMap.put("红楼梦",88F);
        rootMap.put("booksMap",booksMap);
        //5. 创建io流, 流中指定文件的输出位置和文件名
        Writer out = new FileWriter(new File("D:\\Text Work\\IDEA\\WorkSpace\\freemarkerDemo\\src\\main\\resources\\ftl\\hello.html"));
        //6. 生成
        template.process(rootMap, out);
        //7. 关闭流
        out.close();
    }
}
