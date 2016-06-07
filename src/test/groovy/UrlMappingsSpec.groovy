import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import test.SiteController
import test.UrlMappings

@TestFor(UrlMappings)
@Mock(SiteController)
class UrlMappingsSpec extends Specification
{
	void "test language mappings"() {
		expect:
		assertUrlMapping ("/actionOne", controller: 'simple', action: "action1")
//		assertForwardUrlMapping("/actionTwo", controller: 'simple', action: "action2")
	}
}
