package cn.starteasy.core.common.adminui.backend.domain.dto;


import cn.starteasy.core.common.adminui.backend.domain.Resource;

import java.util.List;

/**
 * Created by wdong on 15/7/31.
 */
public class ResourceDTO {

    private Resource resource;
    private List<ResourceDTO> list;

    public List<ResourceDTO> getList() {
        return list;
    }

    public void setList(List<ResourceDTO> list) {
        this.list = list;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
