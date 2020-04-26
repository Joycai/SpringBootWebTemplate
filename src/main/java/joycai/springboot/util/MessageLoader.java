package joycai.springboot.util;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * 静态字符串加载工具
 */
public class MessageLoader {

    final static String bundleName = "message";

    static MessageLoader instance = null;

    public static MessageLoader getInstance() {
        if (instance == null) {
            instance = new MessageLoader();
        }
        return instance;
    }

    MessageSource messageSource;

    private MessageLoader() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(bundleName);
        messageSource.setDefaultEncoding("UTF-8");
        this.messageSource = messageSource;
    }

    public String getMessage(final String key, final Locale locale) {
        return messageSource.getMessage(key, null, locale);
    }

    public String getMessageEn(final String key) {
        return getMessage(key, Locale.ENGLISH);
    }
}
