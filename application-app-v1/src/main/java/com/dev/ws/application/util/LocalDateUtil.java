package com.dev.ws.application.util;

import java.time.LocalDate;
import java.util.function.Supplier;

public class LocalDateUtil {

	public static Supplier<LocalDate> getLocalDate = () -> {
		return LocalDate.now();
	};
}