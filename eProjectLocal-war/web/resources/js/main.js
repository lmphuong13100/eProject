(function($){
	if (window.use_quickview_swatch){			
		Bizweb.optionsQVMap = {}
		Bizweb.updateOptionsQVInSelector = function(t) {
			switch (t) {
				case 0:
					var n = "root";
					var r = $(".quickViewProductVariants .single-option-selector:eq(0)");
					break;
				case 1:
					var n = $(".quickViewProductVariants .single-option-selector:eq(0)").val();
					var r = $(".quickViewProductVariants .single-option-selector:eq(1)");
					break;
				case 2:
					var n = $(".quickViewProductVariants .single-option-selector:eq(0)").val();
					n += " / " + $(".quickViewProductVariants .single-option-selector:eq(1)").val();
					var r = $(".quickViewProductVariants .single-option-selector:eq(2)")
					}
			var i = r.val();
			r.empty();
			var s = Bizweb.optionsQVMap[n];
			for (var o = 0; o < s.length; o++) {
				var u = s[o];
				var a = $("<option></option>").val(u).html(u);
				r.append(a)
			}
			$('.swatchQuickView[data-option-index="' + t + '"] .quickViewSwatchElement').each(function() {
				if ($.inArray($(this).attr("data-value"), s) !== -1) {
					$(this).removeClass("soldout").show().find(":radio").removeAttr("disabled", "disabled").removeAttr("checked")
				} else {
					$(this).addClass("soldout").hide().find(":radio").removeAttr("checked").attr("disabled", "disabled")
				}
			});
			if ($.inArray(i, s) !== -1) {
				r.val(i)
			}
			r.trigger("change")
		};
		Bizweb.linkOptionQVSelectors = function(t) {			
			for (var n = 0; n < t.variants.length; n++) {
				var r = t.variants[n];
				if (r.available) {
					Bizweb.optionsQVMap["root"] = Bizweb.optionsQVMap["root"] || [];
					Bizweb.optionsQVMap["root"].push(r.option1);
					Bizweb.optionsQVMap["root"] = Bizweb.uniq(Bizweb.optionsQVMap["root"]);
					if (t.options.length >= 1) {
						var i = r.option1;
						Bizweb.optionsQVMap[i] = Bizweb.optionsQVMap[i] || [];
						Bizweb.optionsQVMap[i].push(r.option2);
						Bizweb.optionsQVMap[i] = Bizweb.uniq(Bizweb.optionsQVMap[i])
					}
					if (t.options.length === 3) {
						var i = r.option1 + " / " + r.option2;
						Bizweb.optionsQVMap[i] = Bizweb.optionsQVMap[i] || [];
						Bizweb.optionsQVMap[i].push(r.option3);
						Bizweb.optionsQVMap[i] = Bizweb.uniq(Bizweb.optionsQVMap[i])
					}
				}
			}
			Bizweb.updateOptionsQVInSelector(0);
			if (t.options.length > 1) Bizweb.updateOptionsQVInSelector(1);
			if (t.options.length === 3) Bizweb.updateOptionsQVInSelector(2);
			$(".quickViewProductVariants .single-option-selector:eq(0)").change(function() {
				Bizweb.updateOptionsQVInSelector(1);
				if (t.options.length === 3) Bizweb.updateOptionsQVInSelector(2);
				return true
			});
			$(".quickViewProductVariants .single-option-selector:eq(1)").change(function() {
				if (t.options.length === 3) Bizweb.updateOptionsQVInSelector(2);
				return true
			})
		}
		
	}
	$(document).ready(function(){	
		t.init();
		if (window.inPageCollection){
            t.selectFilterByCurrentQuery();
            t.renderFilterdItems();
            $('#filter-value').on('click',function(){
                t._toggleFilterdqdt(this)
            })
            $('.filtersTool input[type="checkbox"]').on('change',function(){
                t.toggleFilter(this);
            })
            $('#filterClearAll').on('click',function(){             
                t.clearAllFiltered();
            })
            $('.selectedFilterItem a').on('click',function(){
                 var id = $(this).data('id');
                 t.removeFilteredItem(id);
            })
            $('.switch-view').on('click',function(){                
                    var view = $(this).data('view');                    
                    t.switchView(view,this);                    
                                
            })
            $('#sortBy a').on('click',function(e){
				e.preventDefault();
                var val = $(this).attr('href');
                t.sortby(val);
            })
            $('.paginate a').on('click',function(){
                var page = $(this).data('page');
                console.log(page);
                t.doSearch(parseInt(page));
            })
        }
	}),
	$(window).resize(function(){
		var ww = $(window).width();
		if (ww < 992){
			t.initClickNavMobileBigCollection()
		}
	}),
	$(window).load(function(){	
		$(this).scroll(function(){
			$(this).scrollTop() > 200 ? $('.btn-fixed').fadeIn() : $('.btn-fixed').fadeOut();			
		})

	}),	
	$(document).on('click touchstart',function(i){
            var dropDownButton = $('.dropDownButton'),
                blockDropList = $('.dropList'),                
                LeftPush = $('#LeftPush'),
				mainMenu = $('.offset-menu');                        
            if (dropDownButton.is(i.target) || dropDownButton.has(i.target).length !== 0) {                
                t.closeLeftPush();
            } else if (blockDropList.is(i.target) || blockDropList.has(i.target).length !== 0){
                t.closeLeftPush();
            } else if (LeftPush.is(i.target) || LeftPush.has(i.target).length !== 0 || mainMenu.is(i.target) || mainMenu.has(i.target).length !== 0){
                t.closeDropList();
            } else {
                t.closeLeftPush();
                 t.closeDropList();
            }
        });		
	var t = {
		init: function() {
				this.initSlideshow(),
				this.initMobileMenu(),
				this.initDropDownButton(),
				this.initLeftPush(),
				this.initNewsLetterForm(),
				this.initOrderForm(),				
				this.ImageLazyLoad(),
				this.initQuickView(),
				this.initDropDownCart(),
				this.initQuickviewAddToCart(),
				this.initAddToCart(),
				this.initProductAddToCart(),				
				this.initOwlThumbsImage(),
				this.initSpecialCollection(),
				this.initBrands(),           
				this.initRelatedProduct(),
				this.initScrollTop(),			
				this.initPrintCollection(),
				this.specialCountDownProduct(),
				this.initBtnNavMobileBigCollection(),
				this.initClickNavMobileBigCollection(),
				this.navFixedOnDesktop()
		},
		initBtnNavMobileBigCollection: function(){
			if ($('.big-collection').length > 0){
				$('.navmobile-big-collection a').click(function(e){
					e.preventDefault();
					var $this = $(this);
					var id = $this.attr('href');					
					if (!$this.parent().hasClass('active')){
						$this.parents('.navmobile-big-collection').children('li').removeClass('active');
						$this.parent().addClass('active');
						$('.tab-index a[href="'+ id +'"]').trigger('click');
					}
				})
			}
		},
		initClickNavMobileBigCollection: function(){
			if ($('.big-collection').length > 0){
				$('.big-collection').each(function(){
					var root = $(this);
					var id = root.find('.tab-pane.active').attr('id');
					root.find('.navmobile-big-collection').children().removeClass('active');
					root.find('.navmobile-big-collection a[href="#' + id + '"]').parent().addClass('active');
				})
				
			}
		},
		initSlideshow: function(){
			$('.slideshow').owlCarousel({
				singleItem: true,
				autoPlay: 8000,
				pagination: false,
				navigation: true,
				navigationText:['<i class="fa fa-caret-left"></i>','<i class="fa fa-caret-right"></i>'],
				transitionStyle : "fade"				
			});            
		},
		initMobileMenu: function(){
			$('.mobile-menu').each(function(){
				$(this).accordion({
					accordion: false,
					speed: 300,
					closedSign: '<i class="fa fa-angle-down"></i>',
					openedSign: '<i class="fa fa-angle-up"></i>'
				})
			})
		},
		
		initDropDownButton: function(){
            $('.dropDownButton').bind('click',function(){
                var target = $(this).data('target');                
                if (target && !$(this).hasClass('active')){                    
                    t.closeDropList();
                    $(target).stop(true,true).slideDown();
                    $(this).addClass('active');
                } else {
                    t.closeDropList();
                }           
                return false;
            });
        },
        closeDropList: function(){
            $('.dropList').stop(true,true).slideUp();
            $('.dropDownButton').removeClass('active');
        },      
		
				
		initLeftPush: function(){
			var menuLeft = $('#offset-menu-s1'),
				showLeftPush = $( '#LeftPush' ),
				body = $('body');
			showLeftPush.on('click',function(){
				$(this).toggleClass('active');
				body.toggleClass('offset-push-right');
				menuLeft.toggleClass('offset-menu-left-open');
			})
		},
		closeLeftPush: function(){
			$( '#LeftPush' ).removeClass('active');
			$('#offset-menu-s1').removeClass('offset-menu-left-open');
			$('body').removeClass('offset-push-right');
		},
		toggleFilter: function(e) {
          t._toggleFilter(e);
           t.renderFilterdItems();
           t.doSearch(1);
        },
        _toggleFilterdqdt : function(e) {
          var $element = $(e);
          var group = 'Khoảng giá';
          var field = 'price_min';
          var operator = 'OR';   
          var value = $element.attr("data-value");  
          filter.deleteValuedqdt(group, field, value, operator);
          filter.addValue(group, field, value, operator);
          t.renderFilterdItems();
          t.doSearch(1);
        },
        _toggleFilter : function(e) {
          var $element = $(e);
          var group = $element.attr("data-group");
          var field = $element.attr("data-field");
          var text = $element.attr("data-text");
          var value = $element.attr("value");
          var operator = $element.attr("data-operator");
          var filterItemId = $element.attr("id");

          if (!$element.is(':checked')) {
              filter.deleteValue(group, field, value, operator);
          }
          else{
              filter.addValue(group, field, value, operator);
          }      
        },
        renderFilterdItems : function() {         
          var $container = $(".selectedFilterList ul");
          $container.html("");
          $(".filter-container input[type=checkbox]").each(function() {
              if ($(this).is(':checked')) {
                  var id = $(this).attr("id");
                  var name = $(this).next("label").text();                
                  t.addFilteredItem(name, id);
              }
          });
          if($(".filter-container input[type=checkbox]:checked").length > 0)
              $(".selectedFilter").show();
          else
              $(".selectedFilter").hide();
         
        },
        addFilteredItem : function (name, id) {
          var filteredItemTemplate = "<li class='selectedFilterItem'>{1} <a href='javascript:void(0);' data-id='{3}'><i class='close'>(Xóa)</i</a></li>";         
          filteredItemTemplate = filteredItemTemplate.replace("{1}", name);
          filteredItemTemplate = filteredItemTemplate.replace("{3}", id);
          var $container = $(".selectedFilterList ul");
          $container.append(filteredItemTemplate);
         $('.selectedFilterItem a').on('click',function(){
             var id = $(this).data('id');
             t.removeFilteredItem(id);
         })
        },
        removeFilteredItem : function(id) {         
          $(".filter-container #" + id).trigger("click");
        },
        clearAllFiltered : function() {
            filter = new Bizweb.SearchFilter();         
            if (collection_id > 0){
                 filter.addValue("collection", "collections", collection_id , "AND");
            } 
            $(".selectedFilterList ul").html("");
            $('.filter-container input[type="checkbox"]').attr('checked', false);
            $(".selectedFilter").hide();
                t.doSearch(1);
        },
        doSearch: function(page, options) {
          if(!options) options = {};
          $('.fullLoading').show();
		  filter.search({
               view: selectedViewData,
               page: page,
               sortby: selectedSortby,
               success: function (html) {				   
                   var $html = $(html);
                   // Muốn thay thẻ DIV nào khi filter thì viết như này
                   var $Products = $($html[0]); 
                   $(".collectionDisplay").html($Products.html());
                   t.pushCurrentFilterState({sortby: selectedSortby, page: page});  
                   $('.fullLoading').hide();                   
                   $('[data-toggle="tooltip"]').tooltip();                 
                   t.ImageLazyLoad();
				   $('.contactWithShop').unbind('click').bind('click',t.initOrderForm());
				   $('.quickview-btn').unbind('click').bind('click',t.initQuickView());
				   $('.add-cart').unbind('click').bind('click',t.initAddToCart());	
                    $('.paginate a').on('click',function(){
                        var page = $(this).data('page');
                        console.log(page);
                        t.doSearch(parseInt(page));
                    })
                   $('html, body').animate({
                       scrollTop: $('.collectionDisplay').offset().top
                   }, 0);     

                },
                error: function(){
                   $('.fullLoading').fadeOut();                   
                    alert('Đã xảy ra lỗi, xin hãy thử lại sau giây lát');
                }
           });
           
          
        },
        pushCurrentFilterState : function (options) {
          if(!options) options = {};
          var url = filter.buildSearchUrl(options);
          var queryString = url.slice(url.indexOf('?'));              
          if(selectedViewData == 'data_list'){
              queryString = queryString + '&view=list';              
          }
          else{
              queryString = queryString + '&view=grid';                
          }

          t.pushState(queryString);
        },
        pushState : function(url) {
          window.history.pushState({
              turbolinks: true,
              url: url
          }, null, url)
        },
        switchView : function(view,el) {             
             if (!$(el).hasClass('active')){                 
                 $('.switch-view').removeClass('active');
                 $(el).addClass('active');
             } else {
                 return false;
             }
             switch(view) {
                 case "list":
                     selectedViewData = "data_list";                       
                     break;
				 case "grid":
					 selectedViewData = "data";
					 break;
                 default:
                     selectedViewData = "data";
                     break;
             }             
             t.doSearch(1);
        }, 
        sortby : function(sort) {            
             switch(sort) {
                 case "price-asc":
                     selectedSortby = "price_min:asc";                     
                     break;
                 case "price-desc":
                     selectedSortby = "price_min:desc";
                     break;
                 case "alpha-asc":
                     selectedSortby = "name:asc";
                     break;
                 case "alpha-desc":
                     selectedSortby = "name:desc";
                     break;
                 case "created-desc":
                     selectedSortby = "created_on:desc";
                     break;
                 case "created-asc":
                     selectedSortby = "created_on:asc";
                     break;
                 case "default":
                     selectedSortby = "";
                     break;
                 default:
                     selectedSortby = "";
                     break;
             }
             t.doSearch(1);
         }, 
        _selectSortby : function(sort) {    
             switch(sort) {
                 case "price-asc":
                     selectedSortby = "price_min:asc";
                     break;
                 case "price-desc":
                     selectedSortby = "price_min:desc";
                     break;
                 case "alpha-asc":
                     selectedSortby = "name:asc";
                     break;
                 case "alpha-desc":
                     selectedSortby = "name:desc";
                     break;
                 case "created-desc":
                     selectedSortby = "created_on:desc";
                     break;
                 case "created-asc":
                     selectedSortby = "created_on:asc";
                     break;
                 default:
                     selectedSortby = sort;
                     break;
             }
         },
         selectFilterByCurrentQuery : function() {
               var isFilter = false;
               var url = window.location.href;
               var queryString = decodeURI(window.location.search);
               var filters = queryString.match(/\(.*?\)/g);

               if(filters && filters.length > 0) {
                   filters.forEach(function(item) {
                       item = item.replace(/\(\(/g, "(");
                       var element = $(".filter-container input[value='" + item + "']");
                       element.attr("checked", "checked");
                       t._toggleFilter(element);
                   });

                   isFilter = true;
               }

               var sortOrder = t.getParameter(url, "sortby");
               if(sortOrder) {
                   t._selectSortby(sortOrder);             
               }
               if(isFilter) {
                   t.doSearch(1);
               }
         },
         getParameter : function(url, name) {
               name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
               var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                   results = regex.exec(url);
               return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
          },
		validateEmail : function(email){
			var regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  			return regex.test(email);
		},
		initNewsLetterForm: function(){
            if ($('.form-newsletter').length > 0){
                $('.form-newsletter').submit(function(e){
                    e.preventDefault();
                    var $this = $(this);
					var email = $this.find('input[name="contact[email]"]');
					if (!t.validateEmail(email.val())){
						email.addClass('error').tooltip({title: "Xin hãy điền lại trường này!", trigger: "focus"}).trigger('focus');
						setTimeout(function(){
							email.removeClass('error').tooltip('destroy');
						},4000);
						return false;
					}
                    $.ajax({
                        type: "POST",                       
                        url: "/contact",
                        data: $this.serialize(),
                        beforeSend: function(){
                            $this.find('button').hide();                            
                        },
                        success: function(){                            
                            $this.html('<h3>&#10004; Chúc mừng bạn đã đăng ký thành công.</h3>');
                        },
                        error: function(){
                            $this.find('button').show();
                            $this.find('input[type="email"]').val('Đăng ký thất bại hãy thử lại sau giây lát.');
                        }
                    });
                    return false;
                });
            }
        },
		initOrderForm: function(){
            if ($('.contactWithShop').length > 0){              
                $('body').delegate('.contactWithShop','click',function(){                   
                    $('#orderForm').html('');
                    var template = $('.orderFormTemplate').html(),              
                        name = $(this).attr('data-code'),
                        form = $('#orderForm').append(template);
                    var n = form.find('.templateTitleOrderForm').val().replace(/\{CODE\}/g,name);
                    form.find('.templateTitleOrderForm').val(n);        
                    $('#orderForm').modal('show');
                    t.AJAXOrderForm();
                })
            }
        },
		initQuickViewOrderForm: function(){            
                $('.quickViewContact').click(function(){                    
                    var template = $('.orderFormTemplate').html(),              
                        name = $(this).attr('data-code'),
                        form = $('#orderForm').append(template);
                    var n = form.find('.templateTitleOrderForm').val().replace(/\{CODE\}/g,name);
                    form.find('.templateTitleOrderForm').val(n);        
                    $('#orderForm').modal('show');
                    $('#quickView').modal('hide');
                    t.AJAXOrderForm();
                })
            
        },
		 AJAXOrderForm: function(){
            $('#orderForm .orderFormActions').submit(function(e){
                e.preventDefault();
                    var $this = $(this);  
				    var name = $this.find('input[name="contact[Name]"]');
					var email = $(this).find('input[name="contact[email]"]');
					var body = $(this).find('textarea[name="contact[Body]"]');
					if (name.val() == ''){						
						name.addClass('err').tooltip({title: "Không được bỏ trống trường này!", trigger: "focus"}).trigger('focus');
						setTimeout(function(){
							name.removeClass('err').tooltip('destroy');							
						},4000);
						return false;
					} else if (!t.validateEmail(email.val())){
						email.addClass('err').tooltip({title: "Xin hãy điền lại trường lại!", trigger: "focus"}).trigger('focus');
						setTimeout(function(){
							email.removeClass('err').tooltip('destroy');							
						},4000);
						return false;
					} else if (body.val() == ''){						
						body.addClass('err').tooltip({title: "Không được bỏ trống trường này!", trigger: "focus"}).trigger('focus');
						setTimeout(function(){
							body.removeClass('err').tooltip('destroy');							
						},4000);
						return false;
					}
                    $.ajax({
                        type: "POST",                       
                        url: "/contact",
                        data: $this.serialize(),
                        beforeSend: function(){
                            $this.find('.AJAXFormContactLoading').show();
                            $this.find('.orderFormInput').hide();
                        },
                        success: function(){
                            $this.find('.AJAXFormContactLoading').hide();
                            $this.find('.orderFormInput').show();
							$this.find('.input-control').removeClass('err').tooltip('destroy');
                            $this.find('.textNoteorderForm').removeClass('error').addClass('success').html('Đặt hàng thành công! Chúng tôi sẽ phản hồi trong thời gian sớm nhất.');
                        },
                        error: function(){
                            $this.find('.AJAXFormContactLoading').hide();
                            $this.find('.orderFormInput').show();
							$this.find('.input-control').removeClass('err').tooltip('destroy');
                            $this.find('.textNoteorderForm').removeClass('success').addClass('error').html('Đặt hàng thất bại. Hãy thử lại sau lát nữa');
                        }
                    });
                    return false;
                });
        },
		ImageLazyLoad: function(){
			if ($('img.lazy').length > 0){ 
				$('img.lazy').lazyload({
					effect: 'fadeIn',
					threshold: 50
				})
			} 
		},
		specialCountDownProduct: function(){
			if ($('.special-product-countdown').length > 0){
            var start_time = new Date();   
                var endDate = {};         
                var el = $('.special-product-countdown');                          
                    str = $(el).data('end').split('_');  
                str.shift();
                for (var i = 0; i < str.length; i++){                                            
                    if (str[i].indexOf('ngay') == 0){                                        
                        endDate.days = str[i].slice(4);
                    } else if(str[i].indexOf('thang') == 0) {                    
                        endDate.months = str[i].slice(5);
                    } else if (str[i].indexOf('nam') == 0){                                       
                        endDate.years = str[i].slice(3);
                    } else { 
                        endDate.error =' Format không đúng';
                    }                
                }                 
                if (!endDate.error){                               
                    var end_time = new Date(endDate.years|| null, endDate.months - 1 || null, endDate.days || null); 
                    var cd = countdown(end_time,function(ts) {
							el.children('.days').html(ts.days + '<span>Ngày</span>');
							el.children('.hours').html(ts.hours + '<span>Giờ</span>');
							el.children('.minutes').html(ts.minutes + '<span>Phút</span>');
							el.children('.seconds').html(ts.seconds + '<span>Giây</span>');                             
                              if (ts.value >= 0){
                                clearInterval(cd);
                                el.html('');                                
                              }
                            }, countdown.DAYS | countdown.HOURS | countdown.MINUTES | countdown.SECONDS);
                } else {
                    el.html(endDate.error);                    
                }
			}
            
        },
		initDropDownCart: function() {              
			t.checkItemsInDropdownCart();
			$(".mini-cart-content .remove").click(function(n) {
				n.preventDefault();
				var r = $(this).parents(".item").attr("id");
				r = r.match(/\d+/g);
				Bizweb.removeItem(r, function(e) {
					t.doUpdateDropdownCart(e)
				})
			});
		},
		initPrintCollection: function(){  
			$('.tab-index li a').on('click', function(){
				var n = $(this).attr('data-collection'),
            limit = parseInt($(this).attr('data-limit') || '12') - 1,          
					link_collection = n,
					h = $(this).attr('href');               								    
				if ($(h).find('.product-grid').length === 0){						
					$.ajax({
						dataType: "json",
						url:"/collections/" + n + "/products.json",
						success: function(n){
							var length_data_return = n['products'].length;
							var count_product = 0;
							while(count_product < length_data_return){
								if(count_product > limit){break;}
								var q = n.products[count_product],
									id = q.id,
									a = q.name,                                 
									g = Bizweb.resizeImage(q.image.src, "large"),
									u = q.alias,
									p = q.variants[0].price,
									s = '<div class="col-xs-12 col-sm-6 col-md-3 col-lg-2 pd7"><div class="product-grid product-ajax-cart" id="product-{ID}"><div class="level-pro-sale" style="display:{DISPLAY_SALE}"><span>-{SALE_DESCREASE}%</span></div><div class="product-img"><a href="/products/{ALIAS}" title="{NAME}"><img src="{IMAGE}" alt="{NAME}" class="img-fix img-product-ajax-cart"></a><a href="javascript:;" class="button dashed quickview-btn" id="{ALIAS}">Xem nhanh</a></div><h3 class="title-product-ajax-cart"><a href="/products/{ALIAS}" title="{NAME}">{NAME}</a></h3><div class="price"><span class="price-product-ajax-cart">{PRICE}</span><del>{COMPARE_PRICE}</del></div><form class="actions form-ajax-action clearfix" method="post" action="/cart/add" id="product-actions-{ID}">';
								if (q.variants.length > 2){                                 
									s = s + '<a href="/products/{ALIAS}" class="button dashed">Chọn sản phẩm</a></form></div>';       
								} else if (p == 0) {
									s = s + '<a href="javascript:void(0);" data-code="{CODE}" class="button dashed contactWithShop">Liên hệ</a></form></div>';
								} else {									
									s = s + '<input type="hidden" name="variantId" value="' + q.variants[0].id + '"><button class="button dashed add-cart"><i class="fa fa-shopping-cart"></i> Cho vào giỏ</button></form></div>';
										
								};
								s = s.replace(/\{ID\}/g, id);
								s = s.replace(/\{ALIAS\}/g, u);
								s = s.replace(/\{NAME\}/g, a);
								s = s.replace(/\{IMAGE\}/g, g);	
								s = s.replace(/\{CODE\}/g, q.variants[0].barcode || q.variants[0].sku || a); 
								q.variants[0].price == 0 ? s = s.replace(/\{PRICE\}/g,'<b>Liên hệ</b>') : s = s.replace(/\{PRICE\}/g, Bizweb.formatMoney(p, window.money_format));
								if (q.variants[0].compare_at_price > q.variants[0].price){									
									s = s.replace(/\{COMPARE_PRICE\}/g, Bizweb.formatMoney(q.variants[0].compare_at_price, window.money_format));
									s = s.replace(/\{SALE_DESCREASE\}/g, Math.round((q.variants[0].compare_at_price - q.variants[0].price)*100/q.variants[0].compare_at_price) );
									s = s.replace(/\{DISPLAY_SALE\}/g,'block')
								} else {
									s = s.replace(/\{COMPARE_PRICE\}/g, '');
									s = s.replace(/\{SALE_DESCREASE\}/g, '');
									s = s.replace(/\{DISPLAY_SALE\}/g,'none')
								}                               
								$(h).append(s);		
								count_product++; 
							}
							$(h).append('<div class="clearfix"></div><a href="\/' + link_collection + '" class="readmore">Xem thêm +</a>');
							$('.contactWithShop').unbind('click').bind('click',t.initOrderForm());							
																					
						}
					});
				}
			});			
		},
		initQuickView: function() {
			$('body').delegate('.quickview-btn','click',function() {
				$('.fullLoading').show();
				var n = $(this).attr("id");	
				var cd = $(this).attr('data-countdown') || 'null';
				$.getJSON('/products/' + n + '.js',function(n){ 					
					var r = $(".quickViewTemplate").html();
					$("#quickView").html(r);
					var i = $("#quickView");
					var r = $(".quickViewTemplate").html();
                    $("#quickView").html(r);
                    var i = $("#quickView");
                    if (n.summary){
                        var s = n.summary.replace(/(<([^>]+)>)|&nbsp;/ig, "");
                        s = s.split(" ").splice(0, 27).join(" ") + "...";
                        i.find('.quickViewProductDesc').text(s);
                    } else if (n.content) {
                        var s = n.content.replace(/(<([^>]+)>)|&nbsp;/ig, "");
                        s = s.split(" ").splice(0, 27).join(" ") + "...";
                        i.find('.quickViewProductDesc').text(s);
                    }
					if (!n.vendor && !n.product_type && !n.variants[0].sku && !n.variants[0].barcode){i.find('.quickViewProductMeta').hide()}
					n.vendor ? i.find('.quickViewProductVendor').html('NSX: ' + '<b>'+n.vendor+'</b>') : i.find('.quickViewProductVendor').hide();
					n.product_type ? i.find('.quickViewProductBrand').html('Loại: ' + '<b>' + n.product_type + '</b>') : i.find('.quickViewProductBrand').hide();                 
					n.variants[0].sku ? i.find('.quickViewProductsku').html('SKU: ' + '<b>'+ n.variants[0].sku + '</b>') : i.find('.quickViewProductsku').hide();
					n.variants[0].barcode ? i.find('.quickViewProductBarcode').html('Mã SP: ' + '<b>'+ n.variants[0].barcode + '</b>') : i.find('.quickViewProductBarcode').hide();
					if (n.variants[0].barcode){
						i.find(".quickViewContact").attr('data-code',n.variants[0].barcode);
					} else if (n.variants[0].sku){
						i.find(".quickViewContact").attr('data-code',n.variants[0].sku);
					}else {
						i.find(".quickViewContact").attr('data-code',n.name);
					}
                    i.find(".quickViewProductTitle").html('<a href="/products' + n.url +'">' + n.name + '</a>');					
					i.find(".quickViewProductVariants").attr("id", "product-actions-" + n.id);
                    i.find(".quickViewProductVariants select").attr("id", "product-select-" + n.id);
                    n.compare_at_price_max > n.price ? i.find(".quickViewProductPrice del").html(Bizweb.formatMoney(n.compare_at_price_max, window.money_format)).show() : i.find(".quickViewProductPrice del").hide();
                    if (!n.available) {
                        i.find("select, input, label").remove();                        
                        i.find(".quickViewAddCart").html("Hết hàng").addClass("disabled").attr("disabled", "disabled");
                    } else {         
						if (n.price == 0){
							i.find(".quickViewProductPrice span").text("Liên hệ");
							i.find('.quickViewContact').show();
							i.find('.quickviewQty').addClass('disabled');
							i.find(".quickViewAddCart").hide();
						} else {
							i.find(".quickViewProductPrice span").html(Bizweb.formatMoney(n.price, window.money_format));
						}
						if (window.use_quickview_swatch) {
                            t.createQuickViewVariantsSwatch(n, i);
                        } else {
                            t.createQuickViewVariants(n, i);
                        }                        
                    }
					if (cd != 'null'){
						var el = i.find('.quickViewCountDown');
						el.show();
						t.countDownQuickView(cd,el);
					}
                    t.loadQuickViewSlider(n, i);
                    t.initQuickviewAddToCart();	
					t.initQuickViewOrderForm();
					$('.fullLoading').hide();
                    $("#quickView").modal('show');			
					

				}).fail(function(){
					$('.fullLoading').hide();
					alert('Lỗi kết nối, hãy thử lại sau giây lát!');
				})
				return false
			});			
		},
		countDownQuickView: function(time,el){
            var start_time = new Date(); 
                var endDate = {};                                                  
                    str = time.split('_');  
                str.shift();
                for (var i = 0; i < str.length; i++){                                            
                    if (str[i].indexOf('ngay') == 0){                                        
                        endDate.days = str[i].slice(4);
                    } else if(str[i].indexOf('thang') == 0) {                    
                        endDate.months = str[i].slice(5);
                    } else if (str[i].indexOf('nam') == 0){                                       
                        endDate.years = str[i].slice(3);
                    } else { 
                        endDate.error =' Format không đúng';
                    }                
                }                 
                if (!endDate.error){                               
                    var end_time = new Date(endDate.years|| null, endDate.months - 1 || null, endDate.days || null); 
                    var cd = countdown(end_time,function(ts) {                                          
                              el.children('.days').html(ts.days + '<span>Ngày</span>');
								el.children('.hours').html(ts.hours + '<span>Giờ</span>');
								el.children('.minutes').html(ts.minutes + '<span>Phút</span>');
								el.children('.seconds').html(ts.seconds + '<span>Giây</span>');
                              if (ts.value >= 0){
                                clearInterval(cd);
                                el.html('');                                
                              }
                            }, countdown.DAYS | countdown.HOURS | countdown.MINUTES | countdown.SECONDS);
                } else {
                    el.html(endDate.error);                    
                }
            
        },
		convertToSlug: function(e){
			e = e.toLowerCase();
			e = e.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g,"a"); 
			e = e.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g,"e"); 
			e = e.replace(/ì|í|ị|ỉ|ĩ/g,"i"); 
			e = e.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g,"o"); 
			e = e.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g,"u"); 
			e = e.replace(/ỳ|ý|ỵ|ỷ|ỹ/g,"y"); 
			e = e.replace(/đ/g,"d"); 
			e = e.replace(/!|@|%|\^|\*|\(|\)|\+|\=|\<|\>|\?|\/|,|\.|\:|\;|\'| |\"|\&|\#|\[|\]|~|$|_/g,"-");
			e = e.replace(/-+-/g,"-");
			e = e.replace(/^\-+|\-+$/g,""); 
			return e; 
		},
		createQuickViewVariants: function(t, n) {
			if (t.variants.length > 1) {
				for (var r = 0; r < t.variants.length; r++) {
					var i = t.variants[r];
					var s = '<option value="' + i.id + '">' + i.title + "</option>";
					n.find("form.variants > select").append(s)
				}
				new Bizweb.OptionSelectors("product-select-" + t.id, {
					product: t,
					onVariantSelected: selectCallbackQuickview
				});

				$(".quick-view .selectize-input input").attr("disabled", "disabled");
				if (t.options.length == 1) {
					$(".selector-wrapper:eq(0)").prepend("<label>" + t.options[0].name + "</label>")
				}
				n.find("form.variants .selector-wrapper label").each(function(n, r) {
					$(this).html(t.options[n].name)
				})
			} else {
				n.find("form.variants > select").remove();
				var o = '<input type="hidden" name="id" value="' + t.variants[0].id + '">';
				n.find("form.variants").append(o)
			}
		},
		createQuickViewVariantsSwatch: function(t,n){
			if (t.variants.length > 1) {
				for (var r = 0; r < t.variants.length; r++) {
                    var i = t.variants[r];
                    var s = '<option value="' + i.id + '">' + i.title + "</option>";
                    n.find(".quickViewProductVariants > select").append(s)
                }
				new Bizweb.OptionSelectors("product-select-" + t.id, {
                    product: t,
                    onVariantSelected: selectCallbackQuickview
                });
				var u = window.asset_url.substring(0, window.asset_url.lastIndexOf("?") - 1);
				var a = "";
				for (var r = 0; r < t.options.length; r++) {
					a += '<div class="swatchQuickView swatch clearfix" data-option-index="' + r + '">';
					a += '<div class="header">' + t.options[r].name + "</div>";
                    var f = false;
					if (/Color|Colour|Màu/i.test(t.options[r].name)) {
						f = true;
					}
					var l = new Array;
					for (var c = 0; c < t.variants.length; c++) {
						var i = t.variants[c];
                        var h = i.options[r];
						var p = this.convertToSlug(h);
						var d = "swatch-" + r + "-" + p;
						if (l.indexOf(h) < 0) {
							a += '<div data-value="' + h + '" class="quickViewSwatchElement ' + (f ? "color" : "") + (i.available ? " available " : " soldout ") + '">';
							if (f){
								a += '<div class="tooltip">' + h + "</div>"
							}
							a += '<input id="QV' + d + '" type="radio" name="option-' + r + '" value="' + h + '" ' + (c == 0 ? " checked " : "") + (i.available ? "" : " disabled") + " />";
							if (f && i.featured_image) {
                                a += '<label for="QV' + d + '" style="background-image: url(' + Bizweb.resizeImage(i.featured_image.src, "thumb") +')"></label>'
                            } else {
                                a += '<label for="QV' + d + '">' + h + '</label>'
                            }								
							a += "</div>";
							if (i.available) {
                                $('#quickView .swatch[data-option-index="' + r + '"] .' + p).removeClass("soldout").addClass("available").find(":radio").removeAttr("disabled");
                            }
							l.push(h)
						}
					}
					a += "</div>"
				}
				n.find(".quickViewProductVariants > select").after(a);
				n.find(".swatch :radio").change(function() {
                    var t = $(this).closest(".swatch").attr("data-option-index");
                    var n = $(this).val();
                    $(this).closest(".quickViewProductVariants").find(".single-option-selector").eq(t).val(n).trigger("change")
                });
				if (t.available) {					
                    Bizweb.optionsQVMap = {};
                    Bizweb.linkOptionQVSelectors(t)
                }
			} else {
                n.find(".quickViewProductVariants > select").remove();
                var v = '<input type="hidden" name="variantId" value="' + t.variants[0].id + '">';
                n.find(".quickViewProductVariants").append(v)
            }
		},	
		

		initScrollTop: function() {
			$("#backtop").click(function() {				
				return $("body,html").animate({
					scrollTop: 0
				}, 400), !1
				return false
			})
		},
		initSpecialCollection: function() {
			$(".owl-special-collection").owlCarousel({
				lazyLoad: true,
				navigation: !0,
				navigationText:['<i class="fa fa-angle-left"></i>','<i class="fa fa-angle-right"></i>'],
				items: 3,
				itemsDesktop: [1199, 2],
				itemsDesktopSmall: [979, 2],
				itemsTablet: [768, 2],
				itemsTabletSmall: [540, 2],
				itemsMobile: [360, 1]
			});
		},
		initBrands: function() {
			$(".owl-brands").owlCarousel({
				navigation:false,                
				items: 5,
				itemsDesktop: [1199, 4],
				itemsDesktopSmall: [979, 4],
				itemsTablet: [768, 3],
				itemsTabletSmall: [540, 2],
				itemsMobile: [360, 1]
			});
		},
		initOwlThumbsImage: function() {
			$(".thumbnail-images").owlCarousel({
				navigation: !0,
				navigationText:['<i class="fa fa-angle-left"></i>','<i class="fa fa-angle-right"></i>'],
				items: 5,
				itemsDesktop: [1199, 4],
				itemsDesktopSmall: [979, 4],
				itemsTablet: [768, 4],
				itemsTabletSmall: [540, 3],
				itemsMobile: [360, 3]
			});
		},

		initRelatedProduct: function(){
			$(".owl-related-product").owlCarousel({
				navigation: !0,
				navigationText:['<i class="fa fa-angle-left"></i>','<i class="fa fa-angle-right"></i>'],
				items: 4,
				itemsDesktop: [1199, 3],
				itemsDesktopSmall: [979, 2],
				itemsTablet: [768, 2],
				itemsTabletSmall: [540, 2],
				itemsMobile: [360, 1]
			});
		},
		loadQuickViewSlider: function(n, r) {           
            if (n.variants.length > 1 && n.variants[0].featured_image){				
                var s = Bizweb.resizeImage(n.variants[0].featured_image, "grande");
            } else {
				if (n.featured_image){
                	var s = Bizweb.resizeImage(n.featured_image, "grande");
				} else if (n.variants[0].featured_image){
					var s = Bizweb.resizeImage(n.variants[0].featured_image, "grande");
				} else {
					var s = window.noimage;
				}					
            }           
            r.find(".quickViewFeaturedImg img").attr('src',s);            
            if (n.images.length > 0) {
                var o = r.find(".quickViewThumbImg");
                for (i in n.images) {
                    var u = Bizweb.resizeImage(n.images[i], "grande");
                    var a = Bizweb.resizeImage(n.images[i], "compact");
                    var l = Bizweb.resizeImage(n.images[i], "original");
                    var f = '<a href="javascript:void(0)" data-image="' + u + '"><img src="'+ a +'" class="img-fix"></a>';                    
                    o.append(f)
                }
                o.find("a").click(function() {                    
                    var t = r.find(".quickViewFeaturedImg img");
                    if (t.attr("src") != $(this).attr("data-image")) {
                        t.attr("src", $(this).attr("data-image"));
                        t.load(function(t) {
                            $(this).unbind("load");
                        })
                    }
                });
                t.initQuickViewCarousel(o)
            }
        },
        initQuickViewCarousel: function(e) {
            if (e) {
                e.owlCarousel({
                    item: 5,
                    itemsDesktop: [1199, 5],
                    itemsDesktopSmall: [979, 5],
                    itemsTablet: [768, 5],
                    itemsTabletSmall: [540, 5],
                    itemsMobile: [360, 3],
                    pagination: false,
                    navigation: true,                       
                    navigationText: ['<i class="fa fa-angle-left"></i>','<i class="fa fa-angle-right"></i>'] 
                });
            }
        },
		initQuickviewAddToCart: function() {            
                $('.quickViewAddCart').click(function() {                   
                    var n = $("#quickView select[name=variantId]").val();
                    if (!n) {
                        n = $("#quickView input[name=variantId]").val()
                    }
                    var r = $("#quickView input[name=quantity]").val();
                    if (!r || 0 >= r) {
                        r = 1
                    } 
                    var i = $(".quickViewProductTitle").text();
                    var s = $(".quickViewFeaturedImg img").attr("src");
                    var p = $(".quickViewProductPrice span").text().replace(/\D+/g,'');
                    t.doAjaxAddToCart(n, r, i, s, p);
                    $("#quickView").modal('hide');
                    return false;
                })            
        },
		initProductAddToCart: function(){
			if ($('.product-add-to-cart').length > 0){
				$('.product-add-to-cart').click(function(n){
					n.preventDefault();					
					if($(this).attr('disabled') != 'disabled'){
						$('.fullLoading').show();
						var r = $(".product-form select[name=variantId]").val();
						if (!r){
							r = $(".product-form input[name=variantId]").val();                                
						}
						var i = $(".product-form input[name=quantity]").val();
						if (!i || i < 0) {
							i = 1
						}
						var s = $('.product-single .product-name').text();                          
						var o = $('#product-featured-image').attr('src');
						var p = $('.product-price span').text().replace(/\D+/g,'');
						t.doAjaxAddToCart(r,i,s,o,p)
					}
				})
			}
		},
		initAddToCart: function(){
			if ($('.add-cart').length > 0){
				$('body').delegate('.add-cart','click',function(n){
					n.preventDefault();					
					if($(this).attr('disabled') != 'disabled'){
						$('.fullLoading').show();
						var r = $(this).parents('.product-ajax-cart');
						var form = $(r).find('.form-ajax-action');
						var s = form.find('input[name=variantId]').val();
						var o = form.find('input[name=quantity]').val();
						if (!o || o < 0) {
							o = 1
						}                        
						var u = $(r).find('.title-product-ajax-cart').text();                        
						var a = $(r).find('.img-product-ajax-cart').attr('src');  
						var p = $(r).find(".price-product-ajax-cart").text().replace(/\D+/g,'');						
						t.doAjaxAddToCart(s,o,u,a,p)
					}
				})
			}
		},
		
		doAjaxAddToCart: function(n, r, i, s, p) {
            $.ajax({
                type: "POST",
                url: "/cart/add.js",
                data: "quantity=" + r + "&variantId=" + n,
                dataType: "json",               
                success: function(n) {
                    $('.fullLoading').hide();
                    $("#noticeAdd").find(".noticeAddInfoTitle").text(i);
                    $("#noticeAdd").find(".noticeAddImg img").attr("src", s);                        
                    $("#noticeAdd").find(".noticeAddInfoQty").html('<i>Số lượng:' + r + '</i>');
                    $("#noticeAdd").find(".noticeAddInfoPrice").html(Bizweb.formatMoney(parseInt(p) * r, window.money_format));
                    $("#noticeAdd").modal('show');
                    setTimeout(function(){$("#noticeAdd").modal('hide');},5000)
                    t.updateDropdownCart();
                },
                error: function(n, r) {
                    $('.fullLoading').hide();
                    alert($.parseJSON(n.responseText).description); 
                }
            })
        },
		updateDropdownCart: function() {
			Bizweb.getCart(function(e) {
				t.doUpdateDropdownCart(e)
			})
		},
		doUpdateDropdownCart: function(n) {
			var r = '<div class="item" id="item-{ID}"><a title="Xóa sản phẩm" class="remove" href="javascript:void(0);">×</a><a href="{URL}" class="text-overflow"><img src="{IMAGE}" width="100" alt="{TITLE}">{TITLE}<span class="qty">{QUANTITY} x {PRICE}</span></a></div>';

			$(".shop-cart .cart-number").html(n.item_count);
			$(".header-panel-mobile .cart-number").html(n.item_count);			
			$(".mini-cart-content .has-items").html("");
			if (n.item_count > 0) {
				for (var i = 0; i < n.items.length; i++) {
					var s = r;
					s = s.replace(/\{ID\}/g, n.items[i].variant_id);
					s = s.replace(/\{URL\}/g, n.items[i].url);
					s = s.replace(/\{TITLE\}/g, n.items[i].name);
					s = s.replace(/\{VARIANT_TITLE\}/g, n.items[i].variant_title);
					s = s.replace(/\{QUANTITY\}/g, n.items[i].quantity);
					s = s.replace(/\{IMAGE\}/g, Bizweb.resizeImage(n.items[i].image, "small"));
					s = s.replace(/\{PRICE\}/g, Bizweb.formatMoney(n.items[i].price, window.money_format));
					$(".mini-cart-content .has-items").append(s)
				}
				$(".mini-cart-content .has-items").append('<div class="clearfix"><span class="pull-left">Tổng:</span><span class="pull-right">' + Bizweb.formatMoney(n.total_price, window.money_format) + '</span></div>');
				$(".mini-cart-content .remove").click(function(n) {
					n.preventDefault();
					var r = $(this).parents(".item").attr("id");
					r = r.match(/\d+/g);
					Bizweb.removeItem(r, function(e) {
						t.doUpdateDropdownCart(e)
					})
				});

			}
			t.checkItemsInDropdownCart()
		},
		checkItemsInDropdownCart: function() {
			if ($(".mini-cart-content .has-items").children('.item').length > 0) {                  
				$(".mini-cart-content .no-item").hide();
				$(".mini-cart-content .has-items").show();                
			} else {
				$(".mini-cart-content .has-items").hide();
				$(".mini-cart-content .no-item").show();                
			}
		},		
		navFixedOnDesktop: function() {
			if ($(window).width() > 1023){
				var fixedNavLarge = $('.mid-header').offset().top;
				$(window).scroll(function(){
					var wpos = $(this).scrollTop();
					if (wpos > fixedNavLarge){
						$('.mid-header').addClass('fixed');
					} else {
						$('.mid-header').removeClass('fixed');
					}            
				})	
			}
		}
	}

	})(jQuery);