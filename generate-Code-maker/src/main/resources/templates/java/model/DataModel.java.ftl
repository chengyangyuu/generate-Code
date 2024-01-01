package ${basePackage}.model;

import lombok.Data;


/**
* 动态模板参数配置
*/
@Data
public class DataModel {
<#list modelConfig.models as modelInfo>

    private ${modelInfo.type} ${modelInfo.fieldName}<#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;
</#list>

}
