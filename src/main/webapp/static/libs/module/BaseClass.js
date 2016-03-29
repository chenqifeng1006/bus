/**
 * 封装基础底层方法
 * ajax
 */
define([
	'jquery',
	'Class',
	'Util',
	'Template',
	'vue',
	'text!../template/util/modalTpl.html',
	'bootstrap',
	'message',
	'Ajax',
	'cookie'
],
function ($,Class,Util,Template,Vue,modalTpl) {

	"use strict";

	return Class.extend({
		init:function(options){
			options = options || {};
			var that = this,
				i;
			for(i in options){
				that[i] = options[i];
			}
			//设置消息提醒的默认效果
			$._messengerDefaults = {
				extraClasses: 'messenger-fixed messenger-theme-future messenger-on-bottom messenger-on-right'
			}
			$.that = that;
		},
		checkForm:function(el){
			var that = this,
				inputs = $(el).find('input').toArray(),
				i = 0,
				length = inputs.length,
				value,
				name,
				forName,
				required,
				requiredMsg,
				maxLen,
				maxLenMsg,
				minLen,
				minLenMsg;
			for(; i < length; i++){
				value = $(inputs[i]).val();
				name = $(inputs[i]).attr('name');
				forName = $.trim($(el).find('[data-for=' + name + ']').text() || ''),
				required = $(inputs[i]).data('required');
				maxLen = $(inputs[i]).data('maxlen');
				minLen = $(inputs[i]).data('minlen');
				requiredMsg = $(inputs[i]).data('requiredmsg') || forName +　'不可为空';
				maxLenMsg = $(inputs[i]).data('maxlenmsg') || forName +　'最大长度不能大于' + maxLen + '位';
				minLenMsg = $(inputs[i]).data('minlenmsg') || forName +　'最小长度不能小于' + minLen + '位';
				if(required && !value){
					that.alert(requiredMsg);
					return false;
				}
				if(maxLen && value.length > maxLen){
					that.alert(maxLenMsg);
					return false;
				}
				if(minLen && value.length < minLen){
					that.alert(minLenMsg);
					return false;
				}
				
			}
			return true;
		},
		/**
		 * ajax get 方法
		 */
		ajax:function(options){
			var that = this;
			options = options || {};
			options.data = options.data instanceof that.Vue ? options.data.$data : options.data;
			options.error = function(message){
				that.error(message)
			}
			$.tgAjax(options);
		},
		/**
		 * ajax post 方法
		 */
		post:function(options){
			options = options || {};
			options.type = 'POST';
			this.ajax(options);
		},
		/**
		 * 获取模板
		 */
		getTemplate:function(tpl,data,otherData){
			var that = this;
			data = data || {};
			otherData = otherData || {};
			var compiled = Template(tpl,{Util:Util,that:that});
			return compiled({data:data,otherData:otherData}) || '';
		},
		/**
		 * 通过模板，数据，上下文环境，渲染页面
		 */
		pageContent:function(options){
			//if(!options.parent || !options.parent.length){
			//	options.parent = options.parent || this.parent || $('body');
			//}
			var parent = options.parent,
				callback = options.callback || function(){},
				methods = options.methods || {},
				template = options.template || '',
				type = options.type || 'html',
				data = options.data || {},
				vueData,
				otherData = options.otherData || {},
				tpl = this.getTemplate(template,data,otherData).replace(/>\s*</g,'><');
			if(type === 'html'){
				parent.html(tpl);
			}else if(type === 'append'){
				parent.append(tpl);
			}else if(type === 'prepend'){
				parent.prepend(tpl);
			}
			vueData = new Vue(
					{
					  el: parent.selector,
					  data: data,
					  methods:methods
					})
			callback();
			return vueData;
		},
		setCookie:function(key,value,expires){
			var obj = {path:'/'};
			expires && (obj.expires = expires);
			//this.removeCookie(key);
			return $.cookie(key,value,obj);
		},
		getCookie:function(key){
			return $.cookie(key);
		},
		removeCookie:function(key){
			var path = '/',
				obj = {path:path};
			return $.removeCookie(key,obj)
		},
		/**
		 * 获取dom的共同方法，并缓存，提高效率
		 */
		dom:function(selector,parent){
			var uuid;
			if(!this.cache){
				this.cache = {dom:{}};
			}
			if(parent && parent.size()){
				uuid = parent.data('uuid') || Util.getUuid();
			}
			if(!this.cache.dom[selector + (uuid || '')] || this.cache.dom[selector + (uuid || '')].is(':hidden') || !this.cache.dom[selector + (uuid || '')].size()){
				if(uuid){
					this.cache.dom[selector + (uuid || '')] = $(selector,parent);
				}else{
					this.cache.dom[selector + (uuid || '')] = $(selector);
				}
			}
			return this.cache.dom[selector + (uuid || '')];
		},
		alert:function(message){
			message = message || '';
			var msg = $.globalMessenger().post(message);
			setTimeout(function(){
				msg.hide();
			},2000)
		},
		error:function(message){
			this.alert(message)
		},
		window:function(options){
			var that = this,
				okFn;
			options.title = options.title || '';
			options.event = options.event || {};
			okFn = options.okFn || function(){};
			options.okFn = function(){
				okFn();
				$('.modal-backdrop').remove();
				$('#myModal').remove();
			}
			options.event['#saveEvent'] = options.okFn;
			$('#myModal').remove();
			this.pageContent({
				parent:$('body'),
				type:'append',
				template:modalTpl,
				data:options,
				callback:function(){
					$('#myModal').modal()
					$('#windowContent').html(options.content);
					that.bindEvent(options.event);
				}
			})
		},
		bindEvent : function(options){
			var i,$body = $('body'),fn;
			for(i in options){
				fn = options[i];
				$body.off('click',i);
				$body.on('click',i,(function(fn){
					return function(e){
						e.stopPropagation();
						fn(e,$(this));
					}
				})(fn,i))
			}
		}
	});
});

