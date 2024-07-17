# COMPONENTE SELECTOR DE CIUDADES
## DESCRIPCIÓN
Es un componente diseñado en Java que permite seleccionar ciudades, un Estado y alguno de sus respectivos municipios correspondientes México, a partir de datos cargados desde un archivo CSV,  puede ser utilizado en diferentes clases como JFrame form, para el diseño de interfaces. 
Para desarrollar este componente se utilizó una clase Java Class llamada CityChooser, en la cual se diseñó el componente y los métodos necesarios para hacerlo funcional.

## CARACTERÍSTICAS
- Selector de ciudades que incluye un Estado y un Municipio, utiliza componentes como JComboBox y JLabel para mostrar y seleccionar dicha información.
- Se puede utilizar para el diseño de interfaces desde clases como JFrame o JDialog.
- Se puede agregar a la paleta de componentes para ser utilizado fácilmente.
- Es adaptable al diseño de cualquier interfaz gráfica.
- Lee datos de un archivo CSV para llenar la información correspondiente a las listas desplegables.
- Los campos de selección se actualizan dinámicamente según la selección anterior.
-  Es posible obtener la información seleccionada en formato de cadena a través de un método proporcionado.

## APLICACIONES
Este componente puede ser utilizado en una variedad de contextos donde se requiere que el usuario seleccione un estado y un municipio, para establecer una ubicación o dirección, como en los siguientes ejemplos:

- **Aplicaciones de Registro** en formularios donde los usuarios deben proporcionar su ubicación para registro o verificación de dirección.

- En **herramientas que necesiten mostrar información específica** basada en la selección de un estado y un municipio.

- Para **plataformas que ofrezcan servicios basados en la ubicación**, como reservaciones de hotel o alquiler de vehículos.

- Al ingresar datos de nacimiento o residencia.

## REQUISITOS PARA LA IMPLEMENTACIÓN
- Java JDK 8 en adelante.

- Un IDE que soporte la librería Swing de Java para poder utilizar y visualizar gráficamente el componente, por ejemplo: NetBeans.
- Un archivo CSV con datos de los estados y sus respectivos municipios en el formato esperado (2 columnas) para que el componente funcione correctamente (el archivo se encuentra del proyecto).

## API
### DESCRIPCIÓN
La clase CityChooser es una subclase de JPanel, contiene el código del diseño del componente y las instrucciones necesarias para hacerlo funcional, este componente permite a los usuarios seleccionar el Estado y Municipio de México del cual son originarios o en el habitan según sea utilizado; se muestran los 32 estados Mexicanos y los municipios de cada uno, así como el número de Estado y número de Municipio seleccionado.

### LIBRERÍAS
| Librería | Descripción |
| ------ | ------------- |
|  ` java.awt.Dimension` | ​ Esta es una librería que define el tamaño de un componente gráfico con propiedades de ancho y alto, utilizado comúnmente para establecer y obtener las dimensiones de elementos en interfaces gráficas de usuario. Lo implementamos para definir un tamaño predeterminado al panel del componente.|
|  ` java.awt.Font` | ​ Maneja la representación del texto mediante propiedades como el tipo de letra, el estilo y el tamaño. Fue utilizada para personalizar la apariencia del texto en los JLabel utilizados.|
|  ` javax.swing `  | Esta es una librería estándar de Java que proporciona componentes y herramientas para crear interfaces gráficas de usuario. En este código, se utilizaron clases como JPanel, JLabel y JComboBox para dar forma a la interfaz de usuario del componente. |
|  ` java.awt.event.ActionEvent y java.awt.event.ActionListener `  |   ActionEvent representa eventos generados por componentes interactivos. Cuando un usuario realiza una acción , se genera un ActionEvent. ActionListener es una interfaz que debe implementarse para responder a estos eventos, definiendo qué acciones tomar cuando ocurren. Esto es fundamental para crear aplicaciones interactivas que reaccionan a las acciones del usuario. En este caso, se utilizaron al manipular las listas desplegables para que se mostraran los diferentes estados y municipios. |
|  ` java.util.List, java.util.ArrayList y java.util.Collections `  |   Estas clases son parte del paquete java.util y se utilizan para almacenar y manipular la lista de información de los estados y municipios. HashMap que es una implementación de la interfaz Map, y sirve para almacenar los datos en pares clave-valor, donde las claves son los Estados y se utilizan para acceder a sus valores asociados, es decir, sus municipios, la clase ArrayList implementa la interfaz List, y sirve para almacenar los elementos en un arreglo dinámico, lo que permite agregar, eliminar y acceder a los elementos de manera eficiente, esta librería también se utilizó para trabajar con Colecciones, en este caso para ordenar una lista. |
|  ` java.io.BufferedReader `  | Esta es una librería que lee texto de un flujo de entrada de manera eficiente al almacenar temporalmente datos en un búfer, en este caso de un csv.  |
|  ` java.io.IOException `  | Esta librería fue utilizada para  cuando ocurre un problema de entrada/salida, como la imposibilidad de leer el archivo. |
|  ` java.io.FileInputStream y java.io.InputStreamReader `  | FileInputStream permite leer datos en bytes desde un archivo, facilitando el acceso y manipulación de archivos binarios. InputStreamReader convierte flujos de bytes en flujos de caracteres, permitiendo leer datos de entrada en un formato comprensible para aplicaciones que manejan texto. Estas librerías fueron implementadas para que se pudieran visualizar los acentos y simbolos contenidos en los nombres de los diferentes estados y municipios al leer el archivo. |
|  ` java.awt.GridLayout`  | Es un administrador de diseño que organiza los componentes en una cuadrícula rectangular, utilizado para organizar los elementos contenidos en el panel. |

### COMPONENTES
| Tipo | Campo | Descripción |
| ------ | ------- | ------------- |
|  ` JComboBox<String> `  |  ` comboEstados` | ​Combo Box para almacenar los Estados obtenidos del archivo csv . |
|  ` JComboBox<String> `  |  ` comboMunicipios `  | Combo Box para almacenar los Municipios asociados a cada Estado, obtenidos del archivo csv. |
|  ` JLabel `  |  ` labelNumeroEstado `  | Etiqueta para imprimir el número  y nombre del Estado seleccionado.  |
|  ` JLabel `  |  ` labelNumeroMunicipio `  | Etiqueta para imprimir el número  y nombre del Municipio seleccionado.|

### Constructor
| Constructor | Descripción |
| ------------- | ------------- |
|  ` CityChooser() `  | Se inicializa el componente, se declara la ruta del archivo csv como parámetro en el método leerCSV, y se inicializa el método para llenar el combo de Estados. |

### Métodos:
| Nombre                | Descripción      |
| ------------------- | ---------------------|
|  ` initComponentes `  | En este método se inicializan y agregan al panel los componentes requeridos para el diseño del nuevo componente, también se establecen los ActionListener para los ComboBox y se activan cuando el usuario selecciona un elemento en el ComboBox correspondiente.|
|  ` leerCSV `  | Este método es utilizado para leer los datos del archivo csv y organizarlos en una estructura de datos que relaciona los estados con sus respectivos municipios.|
|  ` getNumeroEstado `  |  Este método proporciona el número de orden de un Estado en específico en la lista de Estados ordenados.|
|  ` getNumeroMunicipio `  | Este método proporciona el número de orden de un Municipio en específico dentro de un Estado y devuelve un -1 si el estado o municipio no existen en la estructura de datos.|
|  ` llenarComboEstados `  | Este método se encarga de llenar el combo box de Estados con los nombres de los Estados, asegurándose de que estén ordenados alfabéticamente. |
|  ` getInfo `  | Retorna una cadena de texto que combina los textos de labelNumeroEstado y labelNumeroMunicipio. Es útil para obtener información concatenada de estos dos componentes de la interfaz.|
|  ` getPreferredSize()`  | Devuelve un objeto Dimension que especifica el tamaño preferido del componente. En este caso, establece un ancho de 450 píxeles y un alto de 150 píxeles.|
