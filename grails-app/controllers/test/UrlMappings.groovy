package test

class UrlMappings
{

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		"/$lang/$controller/$action?/$id?(.$format)?" {
			constraints {
				lang(matches: /en|ru/)
			}
		}

		"/"(view: "/index")

		"/$lang/" {
			view = '/index'
			constraints {
				lang(matches: /en|ru/)
			}
		}

		"500"(view: '/error')
		"404"(view: '/notFound')
	}
}
