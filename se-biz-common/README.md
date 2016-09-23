业务基础包,会随着业务场景的支持广泛而增加内容

###domain继承体系；
###service继承体系;
###http api相关（返回格式、异常等;并且基于spring mvc 支持创易的特有协议）;

##DAO层 支持泛化的方法类型, 支持基本涵盖了所有场景操作的13个方法;ExDAO是具备业务语义的; 其是对spring-data的扩展
##Service层 是对DAO层的简单包装,不具备业务语义,仅支持事务等技术属性[其不允许暴露为外部服务]; ExService是具备业务语义的;
##Facade层  是对Service和ExService的组装,具备更多更丰富的业务语义; [其主要向外部暴露服务]

并且已经和特定框架绑定死了（spring，mybatis，logback, fastjson）


主要包括以下几部分内容;
1. 
2. 
3. 
4. 
5. 
