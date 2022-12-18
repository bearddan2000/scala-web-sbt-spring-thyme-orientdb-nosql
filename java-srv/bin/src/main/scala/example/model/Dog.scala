package example.model;

import com.orientechnologies.orient.core.record.impl.ODocument;

case class Dog (
    var breed: String,
    var color: String
) {
  var id: java.lang.Long = _

  def this()
  {
    this("", "");
    id = 0L;
  }

  def this(a: java.lang.Long, b: String, c: String)
  {
    this(b, c);
    id = a;
  }

  override def toString() = f"""{"id":$id%d, "breed":"$breed%s", "color":"$color%s"}"""
}


object DogUtil {
  def fromODocument(oDocument: ODocument): Dog = {
    val dog = new Dog()
    dog.id = oDocument.field("id")
    dog.breed = oDocument.field("breed")
    dog.color = oDocument.field("color")
    return dog
  }
}
