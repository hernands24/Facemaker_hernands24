
package com.example.facemaker;
//controls the spinner and determines what is getting selected
/**
 *
 * @author Saylene Hernandez
 * @date 03/03/2021
 *
 */
public enum Style
{
	MUSTACHE(0), SOUL_PATCH(1), GOATEE(2);

	public int position;
	Style(int position) { this.position = position; }
}
