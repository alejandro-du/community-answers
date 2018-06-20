package org.vaadin.alejandro;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@HtmlImport("styles/shared-styles.html")
@Route("")
public class MainView extends VerticalLayout {

    private Grid<Comment> grid = new Grid<>();
    private MonacoEditor monacoEditor = new MonacoEditor();
    private Button button = new Button("Send");

    public MainView() {
        addClassName("main-view");

        Image image = new Image("frontend/images/logo.png", "Logo");
        image.setWidth("300px");

        grid.setHeightByRows(true);
        grid.addColumn(Comment::getDate);
        grid.addColumn(Comment::getContent);
        update();

        monacoEditor.setWidth("100%");

        setHorizontalComponentAlignment(Alignment.END, button);
        button.addClickListener(event -> send(monacoEditor.getValue()));

        add(image, grid, monacoEditor, button);
    }

    private void send(String content) {
        CommentRepository.save(new Comment(content));
        monacoEditor.clear();
        update();
    }

    private void update() {
        grid.setItems(CommentRepository.findAll());
    }
}
