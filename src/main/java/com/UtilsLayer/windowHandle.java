package com.UtilsLayer;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BaseLayer.BaseClass;

public class windowHandle extends BaseClass {

	public String handleTwoWindowByUsingSet(String Parent, Set<String> allWindow) {

		for (String a : allWindow) {
			if (!(a.equals(Parent))) {
				driver.switchTo().window(a);
				return driver.getWindowHandle();

			}

		}
		return null;
	}

	public String handleThreeWindowByUsingSet(String Parent, Set<String> allWindow, String child1) {

		for (String b : allWindow) {
			if (!(b.equals(Parent) && !(b.equals(child1)))) {
				driver.switchTo().window(b);
				return driver.getWindowHandle();

			}
		}
		return null;

	}

	public void handleWindowByArrayList(String Parent, Set<String> allWindow, int index) {

		ArrayList<String> arr = new ArrayList<String>(allWindow);

		driver.switchTo().window(arr.get(index));
	}

}
