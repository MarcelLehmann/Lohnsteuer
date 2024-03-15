package de.powerproject.lohnpap.pap;

import java.util.Date;
import java.util.Calendar;

/**
 * 
 * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer)
 * @date Fri Mar 15 08:35:04 CET 2024
 * 
 */

public class Lohnsteuer {

	public static LohnsteuerInterface getInstance() {
		return getInstance(null);
	}

	public static LohnsteuerInterface getInstance(Date date) {

		if (date != null) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;

			if ((year == 2024 && month >= 1) || year > 2024) {
				return new Lohnsteuer2024();
			}
			if (year == 2023 && month >= 7 && month <= 12) {
				return new Lohnsteuer2023AbJuli();
			}
			if (year == 2023 && month >= 1 && month <= 6) {
				return new Lohnsteuer2023();
			}
			if (year == 2022 && month >= 1 && month <= 12) {
				return new Lohnsteuer2022();
			}
			if (year == 2021 && month >= 1 && month <= 12) {
				return new Lohnsteuer2021();
			}
			if (year == 2020 && month >= 1 && month <= 12) {
				return new Lohnsteuer2020();
			}
			if (year == 2019 && month >= 1 && month <= 12) {
				return new Lohnsteuer2019();
			}
			if (year == 2018 && month >= 1 && month <= 12) {
				return new Lohnsteuer2018();
			}
			if (year == 2017 && month >= 1 && month <= 12) {
				return new Lohnsteuer2017();
			}
			if (year == 2016 && month >= 1 && month <= 12) {
				return new Lohnsteuer2016();
			}
			if (year == 2015 && month == 12) {
				return new Lohnsteuer2015Dezember();
			}
			if (year == 2015 && month >= 1 && month <= 11) {
				return new Lohnsteuer2015();
			}
			if (year == 2014 && month >= 1 && month <= 12) {
				return new Lohnsteuer2014();
			}
			if (year == 2013 && month >= 1 && month <= 12) {
				return new Lohnsteuer2013();
			}
			if (year == 2012 && month >= 1 && month <= 12) {
				return new Lohnsteuer2012();
			}
			if (year == 2011 && month == 12) {
				return new Lohnsteuer2011Dezember();
			}
			if (year == 2011 && month >= 1 && month <= 11) {
				return new Lohnsteuer2011();
			}
			if (year == 2010 && month >= 1 && month <= 12) {
				return new Lohnsteuer2010();
			}
			if (year == 2009 && month >= 1 && month <= 12) {
				return new Lohnsteuer2009();
			}
			if (year == 2008 && month >= 1 && month <= 12) {
				return new Lohnsteuer2008();
			}
			if (year == 2007 && month >= 1 && month <= 12) {
				return new Lohnsteuer2007();
			}
			if (year == 2006 && month >= 1 && month <= 12) {
				return new Lohnsteuer2006();
			}
			throw new IllegalArgumentException("Illegal Date " + date + "");
		}

		return new Lohnsteuer2024();
	}
}