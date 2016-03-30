var pathname = location.pathname;
if(pathname.indexOf('admin')){
    require(['admin/login/Index'],function(Page){
        new Page({}).initPage();
    });
}else if(pathname.indexOf('driver')){
    require(['driver/login/Index'],function(Page){
        new Page({}).initPage();
    });
}else if(pathname.indexOf('index')){
    require(['index/login/Index'],function(Page){
        new Page({}).initPage();
    });
}
//
//require(['login/Register'],function(Page){
//    new Page({}).initPage();
//});
//
//require(['login/FindPassword'],function(Page){
//    new Page({}).initPage();
//});
//
//require(['Main'],function(Page){
//    new Page({}).initPage();
//});