package mn.gateway.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CommonUtil {

	private CommonUtil() {}

	private static final String NON_THIN = "[^iIl1\\.,']";

	public static MultipartFile convert(final File file) throws IOException {

		final FileItem fileItem =
				new DiskFileItemFactory()
				.createItem("file", Files.probeContentType(file.toPath()), false, file.getName());

		try (InputStream in = new FileInputStream(file);
				OutputStream out = fileItem.getOutputStream()) {
			in.transferTo(out);
		} catch (final Exception e) {
			throw new IllegalArgumentException("Invalid file: " + e, e);
		}

		return new CommonsMultipartFile(fileItem);
	}

	public static String lowerCaseTrim(final String str) {
		return str == null ? null : str.toLowerCase().trim();
	}

	public static String generateUUID() {
		final var uuid = UUID.randomUUID();
		return uuid.toString();
	}


	/** @param datePattern yyMMdd HHmmss. */
	public static String generate(final String prefix, final String datePattern, final int count) {
		final var sb = new StringBuilder(prefix.length() + datePattern.length() + count);
		sb.append(prefix);
		final var dateFormat = new SimpleDateFormat(datePattern);
		sb.append(dateFormat.format(new Date()));
		sb.append(RandomStringUtils.randomNumeric(count));
		return sb.toString();
	}

	public static String generateUserCode(final String prefix) {
		final var now = Instant.now().getEpochSecond();
		return prefix + now;
	}

	public static String toTimeStr(final Date time) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(time);

		final var hour = cal.get(Calendar.HOUR);
		final var min = cal.get(Calendar.MINUTE);

		final var sb = new StringBuilder();
		if (hour < 10) {
			sb.append(0).append(hour);
		} else {
			sb.append(hour);
		}
		sb.append(":");
		if (min < 10) {
			sb.append(0).append(min);
		} else {
			sb.append(min);
		}
		return sb.toString();
	}

	private static int textWidth(final String str) {
		return str.length() - str.replaceAll(CommonUtil.NON_THIN, "").length() / 2;
	}

	public static String ellipsize(final String text, final int max) {
		if (CommonUtil.textWidth(text) <= max) {
			return text;
		}

		var end = text.lastIndexOf(' ', max - 3);
		if (end == -1) {
			return text.substring(0, max - 3) + "...";
		}

		var newEnd = end;
		do {
			end = newEnd;
			newEnd = text.indexOf(' ', end + 1);
			if (newEnd == -1) {
				newEnd = text.length();
			}

		} while (CommonUtil.textWidth(text.substring(0, newEnd) + "...") < max);

		return text.substring(0, end) + "...";
	}

	public static String getFirstTwoNumbersOfString2(final String s) {
		final var sb = new StringBuilder(2); // Capacity of 2 chars.

		for (final char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				sb.append(c);

				if (sb.length() == 2) {
					break;
				}
			}
		}
		return sb.toString();
	}

	public static List<Long> parseJsonToLong(final String assignedStudentsJson) {
		return new Gson().fromJson(assignedStudentsJson, new TypeToken<List<Long>>() {}.getType());
	}


}
