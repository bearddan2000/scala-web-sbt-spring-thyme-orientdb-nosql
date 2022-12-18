package example.repository;

import com.orientechnologies.orient.core.db.ODatabaseRecordThreadLocal;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scala.jdk.CollectionConverters._
import scala.collection.mutable.ListBuffer

import example.model.{Dog, DogUtil};

@Repository
class DogRepositoryImpl (
  @Autowired()
  orientDBfactory: ODatabaseDocumentTx
) extends DogRepository {

  override def save(dog: Dog): Unit =
  {
    ODatabaseRecordThreadLocal.instance().set(orientDBfactory);

    // The Class will be automatically created into Orient Studio
    val doc = new ODocument("Dog"); // The entity name is provided as parameter
    doc.field("id", dog.id);
    doc.field("breed", dog.breed);
    doc.field("color", dog.color);
    doc.save();
  }

  override def findAll(): List[Dog] =
  {
    ODatabaseRecordThreadLocal.instance().set(orientDBfactory);

    var dogs: ListBuffer[Dog] = new ListBuffer[Dog]()
    val itr: com.orientechnologies.orient.core.iterator.ORecordIteratorClass[com.orientechnologies.orient.core.record.impl.ODocument] = orientDBfactory.browseClass("Dog")

    while(itr.hasNext)
    {
      val doc: com.orientechnologies.orient.core.record.impl.ODocument = itr.next()
      val util: Dog = DogUtil.fromODocument(doc)
      dogs += util
    }

    return dogs.result()
  }
}
