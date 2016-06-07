package test

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.servlet.support.RequestContextUtils

class LocaleInterceptor
{
	def         springSecurityService
	Logger      logger = LoggerFactory.getLogger(getClass())

	LocaleInterceptor()
	{
		matchAll().excludes(controller: ~/(logout)/)
	}

	/**
	 * Redirects to /lang_code/...
	 * @return
	 */
	boolean before() {
		if (!params?.lang) {
			String lang = RequestContextUtils.getLocale(request).language
			String uri = "/${lang}${request.getRequestURI()}"
			logger.debug('uri is: ' + uri)
			if (uri.indexOf('error') == -1) {
				redirect(uri: uri)
				return false
			}
		}

		true
	}

}
