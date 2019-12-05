# vedioMybatis
mybatis+javaGUI 做的一套录像租赁系统，同为武汉理工大学数据库课程设计实验作品<br>
client包下为界面代码，由于界面是使用eclipse的window builder画的，赋值代码到idea时编码有点出入，所以该包下的编码为GBK，其他包下编码均为utf-8<br>
数据库信息在jdbcConfig.propertiesz下修改<br>


（1）	用户表：存储会员用户的信息。<br>
表3.1	userinfo（用户表）<br>
属性列名	属性说明	数据类型	    码	 	      备注<br>
username	用户名	  varchar(11)	主码		    identity(1,1)<br>
password	密码	  varchar(11)			        not null<br><br>
phonenum	电话	  varchar(11)			        not null<br>
role	    角色	      int			            0——普通会员 1——管理员<br>
					
（2）	录像表：存储录像信息。<br>
表3.2	vedioinfo（录像表）<br>
属性列名	    属性说明	    数据类型	   码 	        备注<br>
id	         录像编号	     int	        主码		    identity(1,1)<br>
name	       片名	         varchar(11)			       not null<br>
inventory    库存量	      int			                not null<br>
price	       租金价格	     float		               not null<br>
					
（3）	文件表：存储录像文件信息及状态。<br>
表3.3	fileinfo（文件表）<br>
属性列名	   属性说明	      数据类型	    码	    	    备注<br>
id	        文件编号	     int	        主码		      identity(1,1)<br>
vid	        录像编号	     int		      外码	        对应vedio.id<br>
status	    状态	         int			                 0——已租出 ——未租出<br>
					
（4）	租赁记录表：存储用户的租赁信息。<br>
表3.4	recordiinfo（租赁记录表）<br>
属性列名	    属性说明	    数据类型	        码		    备注<br>
id	         记录编号	      int	            主码		  identity(1,1)<br>
username	   用户名	       varchar(11)	   外码	     对应useinfo.username<br>
fid	         文件号	       int		         外码	     对应fileinfo.id<br>
lend	       租借日期	      date			                not null<br>
back	       归还日期	      date			<br>
amount	     结算金额	      float			<br>
					

