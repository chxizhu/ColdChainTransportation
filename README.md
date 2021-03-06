# ColdChainTransportation 冷链运输管理系统
随着我国物流领域专业分工细化和低温食品的逐渐普及与成熟,采用全程低温运输的冷链物流(cold chain)悄然兴起。对于冷链物流的质量控制,温度的实时管理是关键。在当前的冷链运输业务中大多数公司主要是通过孤立的温度检测记录仪放在车上进行独立的温度记录管理。因此冷链物流存在着温度难以实时监控,数据无法实时分析的工作现状和瓶颈,对此尚没有系统研究和解决方案。可以预见,一旦实时温控这个冷链运输管理盲点得以解决,将大幅提高监管效率,还会带来巨大的经济利益和社会效益。  本文工作基于上述背景进行。首先本文在对定位技术和监控技术进行对比研究后,设计了冷链运输车辆监控系统方案,选择了车载终端和监控中心的两级结构模式,以GPS定位信息为主，结合GPRS无线通讯传输技术,将GPS定位信息在远端监控中心进行实时的显示、记录和管理。设计了监控中心软件,应用GIS和数据库技术,将车载终端的定位信息、温度信息实时直观地显示在电子地图上,并可对车辆历史数据进行记录、查阅和管理。
系统应该满足中小冷藏运输企业的计算机信息管理的需要,信息系统管理的内容应包括大部分的企业管理工作,实现车辆的调度和跟踪对企业最关心的温湿度记录应该有专门的接口与无线智能温湿度记录监控管理系统相连接达到提高企业的管理水平降低管理成本的目的。
根据产品冷链运输车辆管理状况将系统的使用人员分成三类(1)管理者,负责制定决策及时掌握各种汇总数据进行查询和审批，负责维护系统的正常运行,同时负责各种原始数据的录入工作,以及角色权限管理添加、删除和修改数据等，（2）司机：进行线路打卡，拍照记录等(3)一般用户(客服经理)按不同的权限进行查询、录入等。

# 系统功能
* (1)系统维护模块,包含对用户、司机的添加、删除、修改等。
* (2)车辆管理，车辆的添加、删除、修改等。
* (3)线路管理，线路的添加、删除、修改，打卡管理。
* (4)报表管理，温度管理，报表管理，异常记录管理。
* (5)系统管理，角色管理。
