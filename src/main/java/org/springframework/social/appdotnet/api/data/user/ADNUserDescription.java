package org.springframework.social.appdotnet.api.data.user;

import org.springframework.social.appdotnet.api.data.entities.ADNEntities;

/**
 * @author Arik Galansky
 */
public class ADNUserDescription {
    private String text;
    private String html;
    private ADNEntities entities;

    public ADNUserDescription(String text, String html, ADNEntities entities) {
        this.text = text;
        this.html = html;
        this.entities = entities;
    }

    public String getText() {
        return text;
    }

    public String getHtml() {
        return html;
    }

    public ADNEntities getEntities() {
        return entities;
    }
}
