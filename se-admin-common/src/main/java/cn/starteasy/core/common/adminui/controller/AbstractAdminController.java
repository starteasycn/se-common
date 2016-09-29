package cn.starteasy.core.common.adminui.controller;

import cn.starteasy.core.common.adminui.backend.domain.AdminUser;
import cn.starteasy.core.common.adminui.backend.domain.Resource;
import cn.starteasy.core.common.adminui.backend.domain.ResourceGrid;
import cn.starteasy.core.common.adminui.backend.service.IResourceGridService;
import cn.starteasy.core.common.adminui.controller.helpers.ActionPermHelper;
import cn.starteasy.core.common.domain.persistent.SearchEnum;
import cn.starteasy.core.common.domain.persistent.Sorter;
import cn.starteasy.core.common.domain.persistent.SqlOrderEnum;
import cn.starteasy.core.common.domain.persistent.utils.ConditionBuilder;
import cn.starteasy.core.common.domain.view.BizData4Page;
import cn.starteasy.core.common.service.IPageService;
import cn.starteasy.core.common.service.admin.IDataPermService;
import cn.starteasy.core.common.utils.UserContext;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 管理类controller抽象类
 *  一般的页面都是主页面表格展示，然后弹出页面编辑
 *  对数据权限进行处理
 * <p/>
 * 创建时间: 14-9-3 上午12:03<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public abstract class AbstractAdminController<T extends IPageService> extends AbstractController{
    /** 当前页面的主service  */
    protected T mainService;
    @Autowired
    protected IResourceGridService resourceGridService;
    /** 当前页面的主业务模型  */
    protected String mainObjName;

    /** 当前页面的路径*/
    protected String pagePath;

    /** 当前页面的路径*/
    public String absroduct;

    @Autowired
    private ActionPermHelper actionPermHelper;

    @Autowired
    private IDataPermService dataPermService;

    /**
     * 供子类注入主service
     * @return
     */
    protected abstract T getMainService();
    protected abstract String getBizSys();
    protected abstract String getMainObjName();
    /** 当前页面title */
    protected abstract String getViewTitle();
    /** 父菜单title */
    protected abstract String getParentTitle();

    /***
     * 页面需要业务分类
     * @return
     */
    protected String getPagePath()
    {
        return "";
    }

    protected ModelAndView doRenderMainView(HttpServletRequest request,HttpServletResponse response){
        //request.getRequestURI()
        ModelAndView mav=new ModelAndView("module/"+getPagePath()+getMainObjName());
        ///这里顺便回顾下HashMap的使用方法
        	/*      创建：Map<String,String> map = new HashMap<String,String>();
        	        插入元素：map.put("1","a");
        	        移除元素: map.remove("1");
        	        清空: map.clear();*/
        enhancePreModelAndView(request, mav);
        List<Resource> resourceList = actionPermHelper.getResourcePerm(getAbsroduct());
        mav.addObject("resources", resourceList);

//        List<ResourceGrid> resourceGridList = resourceGridService.findAll();
        Map<String, Object> condition = ConditionBuilder.condition("moduleName", SearchEnum.eq, getMainObjName());//Maps.newHashMap();
        //condition.put("moduleName",getMainObjName());
        //屏蔽掉不显示的列
        //condition.put("hide","0");

        Sorter sorter = new Sorter("orderNum", SqlOrderEnum.ASC);
        List<Sorter> sorterList = Lists.newArrayList();
        sorterList.add(sorter);
        List<ResourceGrid> resourceGridList = resourceGridService.viewList(null, condition, sorterList);//resourceGridService.findList("moduleName",getMainObjName());
        mav.addObject("cols", resourceGridList);

        mav.addObject("bizSys", getBizSys());
        mav.addObject("mainObj", getMainObjName());
        mav.addObject("parentTitle", getParentTitle());
        mav.addObject("title", getViewTitle());

        // 当前用户

        String userName = ((AdminUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName();
        mav.addObject("current_userName", userName);//UserContext.getCurrentUser().getName());

        //按钮功能权限处理
        mav.addObject("actions", actionPermHelper.getActionPerm(getMainObjName(),getAbsroduct()));

        enhanceModelAndView(request,mav);

        return mav;
    }
    /**
     * 在方法前加载重载子类重载, 注入业务数据给 ModelAndView
     * @param mav
     */
    protected void enhancePreModelAndView(final HttpServletRequest request, final ModelAndView mav){

    }

    /**
     * 子类重载, 注入业务数据给 ModelAndView
     * @param mav
     */
    protected void enhanceModelAndView(final HttpServletRequest request, final ModelAndView mav){

    }


    protected BizData4Page doPage(HttpServletRequest request, HttpServletResponse response){
        Integer page = 1;
        if(request.getParameter("page") != null) {
            page = Integer.valueOf(request.getParameter("page"));
        }
        Integer rows = 10;
        if(request.getParameter("rows") != null) {
            rows = Integer.valueOf(request.getParameter("rows"));
        }

        String uri = request.getRequestURI().substring(0, request.getRequestURI().length() - 1);
        //获取参数
        Map<String, Object> conditions = makeQueryCondition(request, response, uri);

        enhancePageConditions(request,conditions);

        return getMainService().queryPage(null, conditions, page, (page-1)*rows, rows, Lists.newArrayList());
    }

    /***
     * 添加查询条件
     * @param conditions
     */
    protected void enhancePageConditions(final HttpServletRequest request,final Map<String, Object> conditions){

    }

    public String getAbsroduct() {
        return StringUtils.isEmpty(absroduct)?null:absroduct;
    }

    public void setAbsroduct(String absroduct) {
        this.absroduct = absroduct;
    }
}
