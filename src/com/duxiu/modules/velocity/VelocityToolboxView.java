package com.duxiu.modules.velocity;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.view.ViewToolContext;

public class VelocityToolboxView extends org.springframework.web.servlet.view.velocity.VelocityToolboxView {
	private static ViewToolManager viewToolManager = null;// 每个视图生成一个view类，所以这里使用static，所有Application的工具都用一个对象
	
	@Override
	protected Context createVelocityContext(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ViewToolContext context = viewToolManager.createContext(getVelocityEngine(), request, response, getServletContext());
		context.putAll(model);
		return context;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		if (viewToolManager == null) {// 每个视图生成一个view类，所以这里使用static，所有Application的工具都用一个对象
			viewToolManager = new ViewToolManager();
			viewToolManager.configure(getToolboxConfigLocation());
		}
	}
	
	/**
	 * 参考 org.apache.velocity.tools.view.VelocityViewServlet
	 * 类下使用org.apache.velocity.tools.view.VelocityView createContext(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	private static class ViewToolManager extends ToolManager {
		public ViewToolContext createContext(	VelocityEngine velocity,
												HttpServletRequest request,
												HttpServletResponse response,
												ServletContext servletContext) {
			ViewToolContext context = new ViewToolContext(velocity, request, response, servletContext);
			prepareContext(context);
			return context;
		}
		
	}
}
