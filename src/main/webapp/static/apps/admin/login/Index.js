define([
    'BasePage',
    'Util',
    'text!../../../template/admin/login/headerTpl.html',
    'text!../../../template/admin/login/contentTpl.html',
    'text!../../../template/admin/login/footerTpl.html'
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
                data:{loginId:'admin',password:'123456'},
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
        			url:'admin/login',
        			data:that.loginData,
        			success:function(data){
        				that.setCookie('admin_username',data.username);
        				that.setCookie('admin_id',data.id);
	        			require(['admin/main/Index'],function(Page){
	        			    new Page({}).initPage();
	        			});
        			}
        		})
        	}
        }
        
    });
});
