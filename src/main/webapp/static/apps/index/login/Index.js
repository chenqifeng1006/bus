define([
    'BasePage',
    'Util',
    'text!../../../template/index/login/headerTpl.html',
    'text!../../../template/index/login/contentTpl.html',
    'text!../../../template/index/login/footerTpl.html'
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
                template:headerTpl,
                data:{},
                callback:function(){
                	setTimeout(function(){
                		$('#register').click(function(){
                			require(['index/login/Register'],function(Page){
    	        			    new Page({}).initPage();
    	        			});
                    	})
                	})
                	
                }
            });
            that.loginData = that.pageContent({
                parent:$('#content'),
                data:{},
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
        			url:'user/login',
        			data:that.loginData,
        			success:function(data){
        				that.setCookie('user_username',data.username);
        				that.setCookie('user_id',data.id);
	        			require(['index/main/Index'],function(Page){
	        			    new Page({}).initPage();
	        			});
        			}
        		})
        	}
        }
        
    });
});
