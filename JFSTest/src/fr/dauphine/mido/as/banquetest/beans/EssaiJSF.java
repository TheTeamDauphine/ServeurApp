
package fr.dauphine.mido.as.banquetest.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class EssaiJSF {
	final String world = "Un essaieeeee de JSF avec un managed bean";

	public String getworld() {
		return world;
	}
}
