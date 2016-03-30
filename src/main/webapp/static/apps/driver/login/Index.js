define([
    'BasePage',
    'Util',
    'text!../../../template/driver/login/headerTpl.html',
    'text!../../../template/driver/login/contentTpl.html',
    'text!../../../template/driver/login/footerTpl.html'
],
function (BasePage,Util, headerTpl,contentTpl,footerTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            BasePage.fn.init.call(that, options);
        },
        initPage:function(){
            var that = this;
            that._loadMainPage();
        },
        _loadMainPage:function(){
            var that = this;
            that.pageContent({
                parent:$('#header'),
                template:headerTpl
            });
            that.loginData = that.pageContent({
                parent:$('#content'),
                data:{loginId:'liubei',password:'123456'},
                template:contentTpl,
                methods:{
                	loginHandler:$.proxy(that._loginHandler,that)
                }
            })
            that.pageContent({
                parent:$('#footer'),
                template:footerTpl
            })
        },
        _loginHandler:function(){
        	var that = this;
        	if(that.checkForm('#content')){
        		that.post({
        			url:'driver/login',
        			data:that.loginData,
        			success:function(data){
        				that.setCookie('driver_username',data.username);
        				that.setCookie('driver_id',data.id);
	        			require(['driver/main/Index'],function(Page){
	        			    new Page({
                                driver:data
                            }).initPage();
	        			});
        			}
        		})
        	}
        }
        
    });
});
