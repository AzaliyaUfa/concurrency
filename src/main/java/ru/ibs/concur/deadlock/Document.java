package ru.ibs.concur.deadlock;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Document {

    private String docName;

    public synchronized void printTheDifference(Document doc) {
        System.out.println("Подготовка к печати различий.");
        doc.compareTheDocuments(this);
        System.out.println("Завершено.");
    }

    public synchronized void compareTheDocuments(Document doc) {
        System.out.format("Сравнение документа %s с документом %s%n", this.docName, doc.docName);
    }

}
