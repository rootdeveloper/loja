/** 
 * PrimeFaces Ecuador Layout
 */
PrimeFaces.widget.Ecuador = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        
        this.wrapper = $(document.body).children('.layout-wrapper');
        this.topbar = this.wrapper.children('.layout-topbar');
        this.sidebar = this.wrapper.children('.layout-sidebar');
        this.menu = this.jq;
        this.menulinks = this.menu.find('a');
        this.expandedMenuitems = this.expandedMenuitems||[];
        this.topbarMenuButton = $('#topbar-menu-button');
        this.nanoContainer = this.sidebar.find('.nano');
        this.topbarUserMenuButton = $('#topbar-profile-menu-button');
        this.topbarUserMenu = $('#topbar-usermenu');
        this.userMenuLinks = this.topbarUserMenu.find('a');
        this.rightPanelButton = $('#right-panel-button');
        this.rightPanel = $('#layout-right-panel');
        this.rightPanelNanoContainer = this.rightPanel.find('.nano');
        this.isRTL = this.wrapper.hasClass('layout-rtl');

        this._bindEvents();

        var isSlimMenu = this.wrapper.hasClass('layout-menu-slim');
        var isHorizontalMenu = this.wrapper.hasClass('layout-menu-horizontal');
        $this = this;


        if(!(isSlimMenu && this.isDesktop()) && !(isHorizontalMenu && this.isDesktop())) {
            this.restoreMenuState();
        }
        
        if(!isSlimMenu && !isHorizontalMenu) {
            this.nanoContainer.nanoScroller({flash:true, isRTL: $this.isRTL});
            this.nanoContainer.children('.nano-content').removeAttr('tabindex');
        }

        this.rightPanelNanoContainer.nanoScroller({flash:true, isRTL: $this.isRTL});

       
    },

    _bindEvents: function() {
        var $this = this;

        $this.menu.on('click.menu', function() {
            $this.menuClick = true;
        });

        $this.topbarMenuButton.off('click.topbar').on('click.topbar', function(e) {
            $this.menuClick = true;

            if($this.isMobile()) {
                $this.wrapper.toggleClass('layout-menu-mobile-active');
            }
            else {
                if($this.isStaticMenu())
                    $this.wrapper.toggleClass('layout-menu-static-inactive');
                else
                    $this.wrapper.toggleClass('layout-menu-overlay-active');
            }

            e.preventDefault();
        });

        $this.menulinks.off('click.menu').on('click.menu', function (e) {
            var link = $(this),
            item = link.parent('li'),
            submenu = item.children('ul');

            if (item.hasClass('active-menuitem')) {
                if (submenu.length) {
                    $this.removeMenuitem(item.attr('id'));
                    item.removeClass('active-menuitem');

                    if($this.isSlimMenu() || $this.isHorizontalMenu())
                        submenu.hide();
                    else
                        submenu.slideUp();
                }

                if(item.parent().is($this.jq)) {
                    $this.menuActive = false;
                }
            }
            else {
                $this.addMenuitem(item.attr('id'));

                if($this.isSlimMenu() || $this.isHorizontalMenu()) {
                    $this.deactivateItems(item.siblings(), false);

                    if(submenu.length === 0) {
                        $this.resetMenu();
                    }
                }
                else {
                    $this.deactivateItems(item.siblings(), true);
                }
                
                $this.activate(item);
                
                if(item.parent().is($this.jq)) {
                    $this.menuActive = true;
                }
            }

            if(!$this.wrapper.hasClass('layout-menu-slim') && !$this.wrapper.hasClass('layout-menu-horizontal')) {
                setTimeout(function() {
                    $this.nanoContainer.nanoScroller();
                }, 450);
            }

            if (submenu.length) {
                e.preventDefault();
            }
        });

        $this.menu.find('> li').off('mouseenter.menu').on('mouseenter.menu', function(e) {    
            if($this.isHorizontalMenu() || $this.isSlimMenu()) {
                var item = $(this);
                
                if(!item.hasClass('active-menuitem')) {
                    $this.menu.find('.active-menuitem').removeClass('active-menuitem');
                    $this.menu.find('ul:visible').hide();
                    
                    
                    if($this.menuActive) {
                        item.addClass('active-menuitem');
                        item.children('ul').show();
                    }
                }
            }
        });

        $this.topbarUserMenuButton.off('click.topbar').on('click.topbar', function (e) {
            $this.userMenuClick = true;

            if ($this.topbarUserMenu.hasClass('usermenu-active')) {
                $this.topbarUserMenu.removeClass('fadeInDown').addClass('fadeOutUp');

                setTimeout(function () {
                    $this.topbarUserMenu.removeClass('usermenu-active fadeOutUp');
                }, 250);
            }
            else {
                $this.topbarUserMenu.addClass('usermenu-active fadeInDown');
            }

            e.preventDefault();
        });

        $this.topbarUserMenu.off('click.topbar').on('click.topbar', function (e) {
            $this.userMenuClick = true;
        });

        $this.userMenuLinks.off('click.menu').on('click.menu', function (e) {
            var link = $(this),
            item = link.parent(),
            submenu = link.next();

            $this.userMenuClick = true;
            item.siblings('.menuitem-active').removeClass('menuitem-active').children('ul').slideUp();

            if (item.hasClass('menuitem-active')) {
                item.removeClass('menuitem-active');
                submenu.slideUp();
            }
            else {
                item.addClass('menuitem-active');
                submenu.slideDown();
            }

            if (submenu.length) {
                e.preventDefault();
            }
            else {
                $this.topbarUserMenu.removeClass('usermenu-active');
            }
        });

        this.rightPanelButton.off('click.rightpanel').on('click.rightpanel', function (e) {
            $this.rightPanelClick = true;
            $this.rightPanel.toggleClass('layout-right-panel-active');
            e.preventDefault();
        });
        
        $(document.body).off('click.layoutBody').on('click.layoutBody', function() {
            if(($this.isHorizontalMenu() || $this.isSlimMenu()) && !$this.menuClick && $this.isDesktop()) {
                $this.menu.find('.active-menuitem').removeClass('active-menuitem');
                $this.menu.find('ul:visible').hide();
                $this.menuActive = false;
            }

            if (!$this.userMenuClick && $this.topbarUserMenu.hasClass('usermenu-active')) {
                $this.topbarUserMenu.removeClass('usermenu-active');
            }

            if ($this.userMenuClick && $this.wrapper.hasClass('layout-menu-mobile-active')) {
                $this.wrapper.removeClass('layout-menu-mobile-active');
            }

            if ($this.rightPanelClick && $this.wrapper.hasClass('layout-menu-mobile-active')) {
                $this.wrapper.removeClass('layout-menu-mobile-active');
            }

            if (!$this.rightPanelClick && !$this.rightPanelButtonClick && $this.rightPanel.hasClass('layout-right-panel-active') && !$this.isDatePickerPanelClicked()) {
                $this.rightPanel.removeClass('layout-right-panel-active')
                $this.rightPanelButton.removeClass('menu-button-rotate')
            }

            if(!$this.menuClick) {
                $this.wrapper.removeClass('layout-menu-overlay-active');
            }

            $this.menuClick = false;
            $this.userMenuClick = false;
            $this.rightPanelClick = false;
            $this.rightPanelButtonClick = false
        });

        $this._initRightPanel();
    },

    isDatePickerPanelClicked: function () {
        if ($.datepicker) {
            var input = $($.datepicker._lastInput);
            if (input.closest('.layout-rightpanel').length && $('#ui-datepicker-div').is(':visible')) {
                return true;
            }
        }
        return false;
    },

    resetMenu: function() {
        this.menu.find('.active-menuitem').removeClass('active-menuitem');
        this.menu.find('ul:visible').hide();
        this.menuActive = false;
    },

    removeMenuitem: function (id) {
        this.expandedMenuitems = $.grep(this.expandedMenuitems, function (value) {
            return value !== id;
        });

        this.saveMenuState();
    },

    addMenuitem: function (id) {
        if ($.inArray(id, this.expandedMenuitems) === -1) {
            this.expandedMenuitems.push(id);
        }
        this.saveMenuState();
    },

    saveMenuState: function() {
        $.cookie('ecuador_expandeditems', this.expandedMenuitems.join(','), {path: '/'});
    },

    clearMenuState: function() {
        $.removeCookie('ecuador_expandeditems', {path: '/'});
    },

    activate: function(item) {
        var submenu = item.children('ul');
        item.addClass('active-menuitem');

        if(submenu.length) {
            if(this.isSlimMenu() || this.isHorizontalMenu())
                submenu.show();
            else
                submenu.slideDown();
        }
    },

    deactivate: function(item) {
        var submenu = item.children('ul');
        item.removeClass('active-menuitem');

        if(submenu.length) {
            submenu.hide();
        }
    },

    deactivateItems: function(items, animate) {
        var $this = this;

        for(var i = 0; i < items.length; i++) {
            var item = items.eq(i),
            submenu = item.children('ul');

            if(submenu.length) {
                if(item.hasClass('active-menuitem')) {
                    var activeSubItems = item.find('.active-menuitem');
                    item.removeClass('active-menuitem');

                    if(animate) {
                        submenu.slideUp('normal', function() {
                            $(this).parent().find('.active-menuitem').each(function() {
                                $this.deactivate($(this));
                            });
                        });
                    }
                    else {
                        submenu.hide();
                        item.find('.active-menuitem').each(function() {
                            $this.deactivate($(this));
                        });
                    }

                    $this.removeMenuitem(item.attr('id'));
                    activeSubItems.each(function() {
                        $this.removeMenuitem($(this).attr('id'));
                    });
                }
                else {
                    item.find('.active-menuitem').each(function() {
                        var subItem = $(this);
                        $this.deactivate(subItem);
                        $this.removeMenuitem(subItem.attr('id'));
                    });
                }
            }
            else if(item.hasClass('active-menuitem')) {
                $this.deactivate(item);
                $this.removeMenuitem(item.attr('id'));
            }
        }
    },

    restoreMenuState: function() {
        var menucookie = $.cookie('ecuador_expandeditems');
        if (menucookie) {
            this.expandedMenuitems = menucookie.split(',');
            for (var i = 0; i < this.expandedMenuitems.length; i++) {
                var id = this.expandedMenuitems[i];
                if (id) {
                    var menuitem = $("#" + this.expandedMenuitems[i].replace(/:/g, "\\:"));
                    menuitem.addClass('active-menuitem');

                    var submenu = menuitem.children('ul');
                    if(submenu.length) {
                        submenu.show();
                    }
                }
            }
        }
    },

    isMobile: function( ){
        return window.innerWidth <= 1024;
    },
    
    isStaticMenu: function() {
        return this.wrapper.hasClass('layout-menu-static') && this.isDesktop();
    },

    isHorizontalMenu: function() {
        return this.wrapper.hasClass('layout-menu-horizontal') && this.isDesktop();
    },
    
    isSlimMenu: function() {
        return this.isDesktop() && this.wrapper.hasClass('layout-menu-slim');
    },

    isDesktop: function() {
        return window.innerWidth > 1024;
    },

    _initRightPanel: function() {
        var $this = this;

        this.rightPanelButton = $('#right-panel-button');
        this.rightPanel = $('#layout-right-panel');
        this.rightPanelNanoContainer = this.rightPanel.find('.nano');
        this.rightPanelNanoContainer.nanoScroller({flash:true});

        this.rightPanelButton.off('click').on('click', function(e) {
            $this.rightPanel.toggleClass('layout-right-panel-active');
            $this.rightPanelButton.toggleClass('menu-button-rotate');
            $this.rightPanelClick = true;
            $this.rightPanelButtonClick = true;
            e.preventDefault();
        });

        this.rightPanel.off('click').on('click', function (e) {
            $this.rightPanelClick = true;

            setTimeout(function() {
                $this.rightPanelNanoContainer.nanoScroller();
            }, 450);
            
            e.preventDefault();
        });
    },

    closeRightPanelMenu: function() {
        if(this.rightPanel) {
            this.rightPanel.removeClass('layout-right-panel-active');
        }
    },

    isMobile: function() {
        return window.innerWidth <= 1024;
    },

    isDesktop: function() {
        return window.innerWidth > 1024;
    }
});

/*!
 * jQuery Cookie Plugin v1.4.1
 * https://github.com/carhartl/jquery-cookie
 *
 * Copyright 2006, 2014 Klaus Hartl
 * Released under the MIT license
 */
(function (factory) {
	if (typeof define === 'function' && define.amd) {
		// AMD (Register as an anonymous module)
		define(['jquery'], factory);
	} else if (typeof exports === 'object') {
		// Node/CommonJS
		module.exports = factory(require('jquery'));
	} else {
		// Browser globals
		factory(jQuery);
	}
}(function ($) {

	var pluses = /\+/g;

	function encode(s) {
		return config.raw ? s : encodeURIComponent(s);
	}

	function decode(s) {
		return config.raw ? s : decodeURIComponent(s);
	}

	function stringifyCookieValue(value) {
		return encode(config.json ? JSON.stringify(value) : String(value));
	}

	function parseCookieValue(s) {
		if (s.indexOf('"') === 0) {
			// This is a quoted cookie as according to RFC2068, unescape...
			s = s.slice(1, -1).replace(/\\"/g, '"').replace(/\\\\/g, '\\');
		}

		try {
			// Replace server-side written pluses with spaces.
			// If we can't decode the cookie, ignore it, it's unusable.
			// If we can't parse the cookie, ignore it, it's unusable.
			s = decodeURIComponent(s.replace(pluses, ' '));
			return config.json ? JSON.parse(s) : s;
		} catch(e) {}
	}

	function read(s, converter) {
		var value = config.raw ? s : parseCookieValue(s);
		return $.isFunction(converter) ? converter(value) : value;
	}

	var config = $.cookie = function (key, value, options) {

		// Write

		if (arguments.length > 1 && !$.isFunction(value)) {
			options = $.extend({}, config.defaults, options);

			if (typeof options.expires === 'number') {
				var days = options.expires, t = options.expires = new Date();
				t.setMilliseconds(t.getMilliseconds() + days * 864e+5);
			}

			return (document.cookie = [
				encode(key), '=', stringifyCookieValue(value),
				options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
				options.path    ? '; path=' + options.path : '',
				options.domain  ? '; domain=' + options.domain : '',
				options.secure  ? '; secure' : ''
			].join(''));
		}

		// Read

		var result = key ? undefined : {},
			// To prevent the for loop in the first place assign an empty array
			// in case there are no cookies at all. Also prevents odd result when
			// calling $.cookie().
			cookies = document.cookie ? document.cookie.split('; ') : [],
			i = 0,
			l = cookies.length;

		for (; i < l; i++) {
			var parts = cookies[i].split('='),
				name = decode(parts.shift()),
				cookie = parts.join('=');

			if (key === name) {
				// If second argument (value) is a function it's a converter...
				result = read(cookie, value);
				break;
			}

			// Prevent storing a cookie that we couldn't decode.
			if (!key && (cookie = read(cookie)) !== undefined) {
				result[name] = cookie;
			}
		}

		return result;
	};

	config.defaults = {};

	$.removeCookie = function (key, options) {
		// Must not alter options, thus extending a fresh object...
		$.cookie(key, '', $.extend({}, options, { expires: -1 }));
		return !$.cookie(key);
	};

}));

if (PrimeFaces.widget.InputSwitch) {
    PrimeFaces.widget.InputSwitch = PrimeFaces.widget.InputSwitch.extend({

        init: function (cfg) {
            this._super(cfg);

            if (this.input.prop('checked')) {
                this.jq.addClass('ui-inputswitch-checked');
            }
        },

        check: function () {
            var $this = this;
           
            this.input.prop('checked', true).trigger('change');
            setTimeout(function(){ 
                $this.jq.addClass('ui-inputswitch-checked');
            },100);
        },

        uncheck: function () {
            var $this = this;
            
            this.input.prop('checked', false).trigger('change');
            setTimeout(function(){ 
                $this.jq.removeClass('ui-inputswitch-checked');
            }, 100);
        }
    });
}