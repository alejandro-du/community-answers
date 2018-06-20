package org.vaadin.alejandro;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

/**
 * @author Alejandro Duarte.
 */
@Tag("monaco-editor")
@HtmlImport("bower_components/monaco-editor/monaco-editor.html")
public class MonacoEditor extends Component implements HasSize {

    public MonacoEditor() {
        clear();
    }

    public void clear() {
        getElement().setProperty("value", "");
    }

    @Synchronize("value-changed")
    public String getValue() {
        return getElement().getProperty("value");
    }
}
