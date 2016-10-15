package cn.starteasy.core.common.adminui.controller.helpers;


import cn.starteasy.core.common.adminui.backend.domain.Resource;
import cn.starteasy.core.common.adminui.backend.domain.ResourceGrid;
import cn.starteasy.core.common.adminui.backend.domain.dto.ResourceDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdong on 15/7/31.
 */
public class MenuUtils {


    public static List<ResourceDTO> getTreeMenu(List<Resource> list)
    {
        List<ResourceDTO> dtoList = new ArrayList<>();
        ResourceDTO resourceDTO = null;
        for(Resource resource:list)
        {
            resourceDTO = new ResourceDTO();
            if(resource.getParentId()==0)
            {
                resourceDTO.setResource(resource);
                resourceDTO.setList(getList(list, resource.getId().intValue()));
                dtoList.add(resourceDTO);
            }
        }
        return dtoList;
    }
    private static List<ResourceDTO> getList(List<Resource> list,int parentId)
    {
        List<ResourceDTO> dtoList = new ArrayList<>();
        ResourceDTO resourceDTO = null;
        for(Resource resource:list)
        {
            resourceDTO = new ResourceDTO();
            if(resource.getParentId()==parentId)
            {
                resourceDTO.setResource(resource);
                resourceDTO.setList(getList(list, resource.getId().intValue()));
                dtoList.add(resourceDTO);
            }
        }
        return dtoList;
    }
}
