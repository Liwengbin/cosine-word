package cn.ncodev;

import cn.ncodev.word.FillWord;
import cn.ncodev.word.FillWord03;
import cn.ncodev.word.FillWord07;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author wenbing.li
 * @date 2020/6/24 14:52
 * @since 1.0
 **/
public class FillWordUtil {

    /**
     * 填充数据到word中
     * @param inputStream 模板流
     * @param map 解析数据源
     * @return XWPFDocument文档对象
     */
    public static XWPFDocument exportWord07(InputStream inputStream, Map<String, Object> map) throws IOException {
        return new FillWord07().fillWord(inputStream, map);
    }

    /**
     * 填充数据到word中
     * @param template 模板地址
     * @param map 解析数据源
     * @return XWPFDocument文档对象
     */
    public static XWPFDocument exportWord07(String template, Map<String, Object> map) throws IOException {
        return new FillWord07().fillWord(template, map);
    }

    /**
     * 解析Word2007版本
     * @param template 模板地址
     * @param list 解析数据源
     * @param ifPagination 是否插入分页
     */
    public static XWPFDocument exportWord07(String template, List<Map<String, Object>> list, boolean ifPagination) throws IOException {
        return new FillWord07().fillWord(template, list,ifPagination);
    }

    /**
     * 解析不同模板的数据到同一个word中
     * @param mapList Map<template, Map<String, Object>>
     * @param ifPagination 是否插入分页
     */
    public static XWPFDocument exportWord07(Map<String, Map<String, Object>> mapList,boolean ifPagination) throws IOException {
        return new FillWord07().fillWord(mapList,ifPagination);
    }

    /**
     * 拼接Word文档，按顺序拼接
     * @param docs word文档-有序集合
     * @param ifPagination 各个文档之间是否插入分页
     * @return 拼接后的文档
     */
    public static XWPFDocument mergeWord07(List<XWPFDocument> docs, boolean ifPagination) throws IOException {
        return new FillWord07().mergeWord(docs,ifPagination);
    }

    /**
     * 填充数据到word中
     * @param template 模板地址
     * @param map 解析数据源
     * @return XWPFDocument文档对象
     */
    public static HWPFDocument exportWord03(String template, Map<String, Object> map) throws IOException {
        return new FillWord03().fillWord(template, map);
    }

    /**
     * .fl模板填充数据到word中
     * @param template 模板地址 .fl 或 .xml 文件
     * @param version freemarker的版本号 例如方式配置：Configuration.VERSION_2_3_0
     * @param outputStream 输出流，内部不关闭此流
     * @param map 解析数据源
     */
    public static void exportFlWord(String template, Version version, OutputStream outputStream, Map<String, Object> map) throws IOException, TemplateException {
        new FillWord().fillFlWord(template, version,outputStream,map);
    }
}
