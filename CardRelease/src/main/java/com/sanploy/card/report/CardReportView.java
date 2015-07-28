/**
 * 
 */
package com.sanploy.card.report;

import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

/**
 * @Description:
 * @Author:
 * @Since: 2015年7月19日 上午1:03:41
 */
@Component("jasperView")
public class CardReportView extends JasperReportsMultiFormatView {

	public static final String ATTACHEMT_FILE_NAME_KEY = "attachmentFileName"; // 格式不为html时的下载文件名
	public static final String DOWNLOAD = "download"; // 浏览器中查看还是下载

	/*
	 * (non-Javadoc)
	 * a
	 * @see org.springframework.web.servlet.view.jasperreports.
	 * JasperReportsMultiFormatView
	 * #renderReport(net.sf.jasperreports.engine.JasperPrint, java.util.Map,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void renderReport(JasperPrint populatedReport, Map<String, Object> model, HttpServletResponse response) throws Exception {
		Object format = model.get(DEFAULT_FORMAT_KEY);

		if (format == null) {
			throw new IllegalArgumentException("model中未找到指定的输出格式(format:html、pdf、xls、csv)");
		}
		if (!format.equals("pdf")) {
			Object attachmentFileName = model.get(ATTACHEMT_FILE_NAME_KEY);
			if (attachmentFileName == null) {
				throw new IllegalArgumentException("model中未指定输出文件名(attachmentFileName)");
			}

//			if ("download".equals(model.get(DOWNLOAD))) {
			Properties contentDispositionMappings = getContentDispositionMappings();
			contentDispositionMappings.put(format.toString(), "attachment; filename=" + attachmentFileName + "." + format);
//			}
		}

		super.renderReport(populatedReport, model, response);
	}

}
