package base.emptyHandle;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:zhouwz
 * @date 2020-06-09 16:13
 */
public class EmptyHandle {

    public static void main(String[] args) {
        stringHandle();
        listHandle();
        mapHandle();
    }

    /**
     * Map集合判空处理
     * isEmpty,判断map内容是否为空，前提是需要初始化，不然会报空指针
     * map == null,判断是否初始化
     * */
    private static void mapHandle() {
        Map map = new HashMap<>();
        map.isEmpty();
        if (map == null){
            System.out.println("map为空");
        }
    }

    /**
     * List集合判空处理
     * isEmpty,判断list内容是否为空，前提是需要初始化，不然会报空指针
     * list == null,判断是否初始化
     *
     * 结论：当list初始化了，用isEmpty; 未初始化用null判断
     *      list2 != null && list2.isEmpty()    判断不为空
     * */
    private static void listHandle() {
        List list1 = null;
        //list未初始化，故调用isEmpty会异常
//        list1.isEmpty();
        if (list1 == null ){
            System.out.println("list1为空");
        }

        List list2 = new ArrayList();
        list2.add(1);
        if (list2 != null && list2.isEmpty()){
            System.out.println("list2不为空");
        }


    }

    /**
     * 字符串处理，可以用apache的工具类
     * isEmpty,判断的标准是str==null或str.length()==0,很明显一个问题就是，当str为一个空格字符串，就无法判空了
     * isBlank，判断依据是在isEmpty基础上，在对空格字符串做处理
     *
     * 结论：isBlank可以更加的常用，判断范围大
     * */
    private static void stringHandle() {
        String strEmpty = " ";
        //isEmpty无法判断空格字符串
        if (StringUtils.isEmpty(strEmpty)){
            System.out.println("isEmpty：str为空");
        }

        String strBlank = " ";
        if (StringUtils.isBlank(strBlank)){
            System.out.println("isBlank：str为空");
        }

    }
}
