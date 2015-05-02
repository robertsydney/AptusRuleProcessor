<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<nav class="page-sidebar" data-pages="sidebar">
      <!-- BEGIN SIDEBAR MENU TOP TRAY CONTENT-->
      <div class="sidebar-overlay-slide from-top" id="appMenu">
        <div class="row">
          <div class="col-xs-6 no-padding">
            <a href="#" class="p-l-40"><img src="${pageContext.request.contextPath}/resources/assets/img/demo/social_app.svg" alt="socail">
            </a>
          </div>
          <div class="col-xs-6 no-padding">
            <a href="#" class="p-l-10"><img src="${pageContext.request.contextPath}/resources/assets/img/demo/email_app.svg" alt="socail">
            </a>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-6 m-t-20 no-padding">
            <a href="#" class="p-l-40"><img src="${pageContext.request.contextPath}/resources/assets/img/demo/calendar_app.svg" alt="socail">
            </a>
          </div>
          <div class="col-xs-6 m-t-20 no-padding">
            <a href="#" class="p-l-10"><img src="${pageContext.request.contextPath}/resources/assets/img/demo/add_more.svg" alt="socail">
            </a>
          </div>
        </div>
      </div>
      <!-- END SIDEBAR MENU TOP TRAY CONTENT-->
      <!-- BEGIN SIDEBAR MENU HEADER-->
      <div class="sidebar-header">
        <img src="${pageContext.request.contextPath}/resources/assets/img/logo_white.png" alt="logo" class="brand" data-src="${pageContext.request.contextPath}/resources/assets/img/logo_white.png" data-src-retina="${pageContext.request.contextPath}/resources/assets/img/logo_white_2x.png" width="78" height="22">
        <div class="sidebar-header-controls">
          <button type="button" class="btn btn-xs sidebar-slide-toggle btn-link m-l-20" data-pages-toggle="#appMenu"><i class="fa fa-angle-down fs-16"></i>
          </button>
          <button type="button" class="btn btn-link visible-lg-inline" data-toggle-pin="sidebar"><i class="fa fs-12"></i>
          </button>
        </div>
      </div>
      <!-- END SIDEBAR MENU HEADER-->
      <!-- START SIDEBAR MENU -->
      <div class="sidebar-menu">
        <!-- BEGIN SIDEBAR MENU ITEMS-->
        <ul class="menu-items">
          <li class="">
            <a href="../supportedDevices/listDevices.do"><span class="title">SupportedDevices</span></a>
            <span class="icon-thumbnail bg-success "><i class="pg-social"></i></span>
          </li>
		  <li class="">
            <a href="../hospitalDevices/listDevices.do"><span class="title">HospitalDevices</span></a>
            <span class="icon-thumbnail bg-complete "><i class="pg-social"></i></span>
          </li>
          <li class="">
            <a href="../organisation/viewOrganisation.do"><span class="title">Organisation</span></a>
            <span class="icon-thumbnail bg-warning "><i class="pg-social"></i></span>
          </li>
          <li class="">
            <a href="../rules/listRules.do"><span class="title">Rules</span></a>
            <span class="icon-thumbnail bg-danger "><i class="pg-social"></i></span>
          </li>
          <li class="">
            <a href="../requests/requestStatus.do"><span class="title">Request Status</span></a>
            <span class="icon-thumbnail bg-primary "><i class="pg-social"></i></span>
          </li>
          <li class="">
            <a href="../hospitalDevices/defineLocation.do"><span class="title">Map Devices</span></a>
            <span class="icon-thumbnail bg-complete "><i class="pg-social"></i></span>
          </li>
		  <li class="">
            <a href="../users/listUsers.do"><span class="title">Users</span></a>
            <span class="icon-thumbnail bg-warning"><i class="pg-social"></i></span>
          </li>
          <li class="">
            <a href="../reports/viewReports.do"><span class="title">Reports</span></a>
            <span class="icon-thumbnail bg-success "><i class="pg-social"></i></span>
          </li>          
        </ul>
        <div class="clearfix"></div>
      </div>
      <!-- END SIDEBAR MENU -->
    </nav>