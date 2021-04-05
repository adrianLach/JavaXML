<h1>JavaXML</h1>
<div>
  <p>Simple way to read and write XML-Files in plain Java.</p>
  <p>Some examples below</p>
</div>
<div>
  <h3>Reading the XML-File</h3>
  <p>There are to ways to load the XML-File into your Programm:</p>
  <br/>
  <p>Parsing the XML File via the Constructor.</p>
  <code>XMLDocument document = new XMLDocument(new File("<your XML-File>"));</code>
  <br/>
  <p>Or by calling the loadXML method. This will override the previous contents of your XMLDocument object.</p>
  <code>XMLDocument document = new XMLDocument();</code>
  <br/>
  <code>document.loadXML(new File("<your XML-File>"));</code>
  https://github.com/adrianLach/JavaXML/blob/bb33c22129496d031d48129bf8e5f8e421bb356d/src/org/javaxml/XMLDocument.java#L16
</div>
