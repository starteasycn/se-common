package cn.starteasy.cloud.demo;

import cn.starteasy.JhipsterGradleSampleApplicationApp;
import cn.starteasy.core.common.adminui.backend.dao.IAdminUserDAO;
import cn.starteasy.core.common.adminui.backend.domain.AdminUser;
import cn.starteasy.core.common.domain.persistent.SearchEnum;
import cn.starteasy.core.common.domain.persistent.Sorter;
import cn.starteasy.core.common.domain.persistent.SqlOrderEnum;
import cn.starteasy.core.common.domain.persistent.utils.ConditionBuilder;
import cn.starteasy.core.common.domain.persistent.utils.SorterBuilder;
import cn.starteasy.core.common.domain.view.admin.SearchField;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * TODO 一句话描述该类用途
 * <p>
 * 创建时间: 16/9/28 下午12:20<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterGradleSampleApplicationApp.class)
@Transactional
public class CRUDTest {

    @Inject
    private IAdminUserDAO adminUserDAO;

    @Test
    public void daoBySelectorAndSorter() {
        Map<String, Object> selector = Maps.newHashMap();
        selector.put("id", "id");
        selector.put("password", "");

        List<Sorter> sorterList = SorterBuilder.sorterList("password", SqlOrderEnum.DESC);
        sorterList.add(new Sorter("login", SqlOrderEnum.DESC));

        List<AdminUser> adminUserList = adminUserDAO.queryList(selector, Maps.newHashMap(), sorterList);

        assertNull(adminUserList.get(0).getName());
        assertNotNull(adminUserList.get(0).getPassword());

        selector.put("login", "name");
        adminUserList = adminUserDAO.queryList(selector, Maps.newHashMap(), sorterList);

        assertNotNull(adminUserList.get(0).getName());
        assertNotNull(adminUserList.get(0).getPassword());
        adminUserList.size();
    }

    @Test
    public void daoByCondition() {
        Map<String, Object> condition = ConditionBuilder.condition("password", SearchEnum.eq, "22");

        List<Sorter> sorterList = SorterBuilder.sorterList("password", SqlOrderEnum.DESC);
        sorterList.add(new Sorter("login", SqlOrderEnum.DESC));

        //nother like nor in
        List<AdminUser> adminUserList = adminUserDAO.queryList(null, condition, sorterList);

        assertEquals("a", adminUserList.get(0).getLogin());
        adminUserList.size();

        condition = ConditionBuilder.condition("login", SearchEnum.alk, "1");

        //left like
        adminUserList = adminUserDAO.queryList(null, condition, sorterList);

        assertEquals("1q", adminUserList.get(0).getLogin());
        adminUserList.size();

        //like
        condition = ConditionBuilder.condition("login", SearchEnum.lk, "1");
        adminUserList = adminUserDAO.queryList(null, condition, sorterList);

        assertEquals("1q", adminUserList.get(0).getLogin());
        assertEquals(2, adminUserList.size());

        //in
        List<String> strings = Lists.newArrayList();
        strings.add("1q");
        strings.add("a");
        strings.add("b");
        condition = ConditionBuilder.condition("login", SearchEnum.in, strings);
        adminUserList = adminUserDAO.queryList(null, condition, sorterList);
        assertEquals(3, adminUserList.size());
//        assertEquals("1q", adminUserList.get(0).getName());
//        adminUserList.size();

        // left + in
        SearchField searchField = new SearchField("password", SearchEnum.lk.getValue(), "1");
        condition.put("password", searchField);
        adminUserList = adminUserDAO.queryList(null, condition, sorterList);

        assertEquals("1q", adminUserList.get(0).getLogin());
        adminUserList.size();
    }
}
