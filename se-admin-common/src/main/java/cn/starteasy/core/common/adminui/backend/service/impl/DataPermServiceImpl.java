package cn.starteasy.core.common.adminui.backend.service.impl;

import cn.starteasy.core.common.adminui.backend.dao.IDataModelDAO;
import cn.starteasy.core.common.adminui.backend.dao.IPermissionDAO;
import cn.starteasy.core.common.adminui.backend.dao.IResourceDAO;
import cn.starteasy.core.common.adminui.backend.dao.IUserDataDAO;
import cn.starteasy.core.common.adminui.backend.domain.DataModel;
import cn.starteasy.core.common.adminui.backend.domain.DatagroupData;
import cn.starteasy.core.common.adminui.backend.domain.Resource;
import cn.starteasy.core.common.domain.UserDomain;
import cn.starteasy.core.common.service.admin.IDataPermService;
import cn.starteasy.core.common.utils.UserContext;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 数据权限 service
 * <p/>
 * 创建时间: 14-8-16 下午10:17<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
@Service("dataPermServiceImpl")
public class DataPermServiceImpl implements IDataPermService {
    @Autowired
    private IDataModelDAO dataModelDAO;
    @Autowired
    private IResourceDAO resourceDAO;
    @Autowired
    private IUserDataDAO userDataDAO;
    @Autowired
    private IPermissionDAO permissionDAO;

    @Override
    public String makeDataPermSql(String resUrl) {
        UserDomain user = UserContext.getCurrentUser();
        Map<String, Object> condition = Maps.newHashMap();
        condition.put("url", resUrl);
        Resource resource = resourceDAO.queryOne(null, condition, null);

        int modelId = 0;
        if (resource != null && resource.getModelId() != null) {
            modelId = resource.getModelId();
        } else {
            //没有主模型，说明没有数据权限设置
            return null;
        }

        condition.clear();
        condition.put("modelId", modelId);
        DataModel dataModel = dataModelDAO.queryOne(null, condition, null); //dataModelDAO.getDataPermSql(modelId);
        if (dataModel == null) {
            return null;
        }
        String formatSql = dataModel.getWhereSql();
        StringBuilder stringBuilder = new StringBuilder("");
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("dataModelId", dataModel.getModelId());
        paramMap.put("userId", user.getId());
        //List<UserData> dataIds = userDataDAO.queryList(paramMap, null, null);
        List<DatagroupData> dataIds = permissionDAO.getDataByPerm(paramMap);


        int size = dataIds.size();

        if (size <= 1) {
            return String.format(formatSql, stringBuilder);
        } else {
            for (DatagroupData userData : dataIds) {
                stringBuilder.append(userData.getDataId()).append(",");
            }
            return String.format(formatSql, stringBuilder.deleteCharAt(stringBuilder.length() - 1));
        }

    }
}
