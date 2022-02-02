# Week 1: JavaFX Basis

<p align="center" >
  02/02/2022
  <a style="text-decoration:none; color: black;" href="https://github.com/KevinZonda">KevinZonda</a>
</p>

## Definition

A JavaFX application is usually done by a class extends abstract class
`javafx.application.Application`.

A GUI application of JavaFX has following components:

- **Stage**  
  It represents the whole window.
- **Scene**  
  It represents the place which contains controls (i.e., without the control bar which
  is at the top of window and usually has minimum, maximum and close action buttons)
- **Control/Widget**  
  e.g. TextBox, CheckBpx, ListBox, etc.

## MVC

MVC, the short form of *Model-View-Controller*, it is a common software architecture
pattern.

- **Model:** The data part
- **View:** the frontend part (could be understood as the user interface, or what user
  can see)
- **Controller:** Receive *View* layer's actions and process them with the *Model* layer.


## Life Cycle of JavaFX

Usually, JavaFX programme contains following life cycle steps.

1. `init()`  
   Initialise resources here. Do **NOT** construct any scene, stage or control here.
   (Maybe will NPE like in WinForms?)
2. `start()`  
   JavaFX applications's **main entrance**
3. `stop()`  
   When JavaFX application ends, what to do? It is used to dispose object, resources, etc.


## FXML

JavaFX uses FXML, which is a XML-like language, to construct UI. (Similar to XAML and HTML.)

FXML structured like:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import PACKAGE_NAME?>

<!-- CODE HERE-->
```

### GridPane

GridPane is a layout which looks like a grid. The layout contains columns and rows, and
looks like

|              |              |              |              |
| ------------ | ------------ | ------------ | ------------ |
| Col 0, Row 0 | Col 1, Row 0 | Col 2, Row 0 | Col N, Row 0 |
| Col 0, Row 1 | Col 1, Row 1 | Col 2, Row 1 | Col N, Row 1 |
| Col 0, Row 2 | Col 1, Row 2 | Col 2, Row 2 | Col N, Row 2 |
| Col 0, Row N | Col 1, Row N | Col 2, Row N | Col N, Row N |

Its code looks like

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.layout.GridPane?>

<GridPane alignment="CENTER"
          hgap="30"
          vgap="20"
          xmlns:fx="http://javafx.com/fxml"
          fx:controller="com.kevinzonda.demo.Controller">

<Control text="0, 0" GridPane.rowIndex="0" GridPane.columnIndex="0"/>
<Control text="0, 1" GridPane.rowIndex="0" GridPane.columnIndex="1"/>
</GridPane>
```

`hgap` is the horizontal gap between columns.  
`vgap` is the vertical gap between rows.  
`xmlns:fx` is the xml's namespace, its value usually is `http://javafx.com/fxml`  
`fx:controller` is the controller class name the layout uses.

### `@FXML` Annotation

In Controller, we usually use `@FXML` annotation to bind the control and action to the
specific object and method. The annotation will ignore the scope modifier
(i.e. `public`, `private`, `protected`.).

#### Control

We usually use `fx:id` to bind the control to the object.

**Example:**

In FXML:
```xml
<Label fx:id="label" />
```
And in its controller:

```java
@FXML
Label label;
```

Then the label will be binded magically.

#### OnAction

To button clicked action, we use `onAction="#methodName"` to handle this and can also use
like this:

**Warning:** do not forget the `#` in front of method name.

**Example:**

In FXML:

```xml
<Button onAction="#buttonClicked" />
```

And in its controller:

```java
@FXML
private void buttonClicked() {
    // so something
}
```

or

```java
@FXML
private void buttonClicked(ActionEvent e) {
    // to get the event source, use `e.getSource()`
    // so something
}
```

The only different thing between these methods is the parameter - one is empty, one has one.

We might found some controls' actions would be very similar or even the same, so we could
try binding the action into the same method. However, to handle the slight different part,
we can use `ActionEvent` to detect who is the sender (i.e. the control send the action) by
`e.getSource()`.

Attention, do **NOT** import the wrong package! Import `javafx.event.ActionEvent` instead
of `java.awt.event.ActionEvent`. The following one is for another GUI framework called awt.

## References

- JavaFX Document - Oracle  
  <https://openjfx.io/javadoc/11/>
- 谈谈MVC模式 - 阮一峰的网络日志  
  https://www.ruanyifeng.com/blog/2007/11/mvc.html
- Explain the life cycle of a JavaFX Application - tutorialspoint  
  <https://www.tutorialspoint.com/explain-the-life-cycle-of-a-JavaFX-application>
- Java FX fxml on Action - StackOverflow  
  <https://stackoverflow.com/questions/17344698/java-fx-fxml-on-action>