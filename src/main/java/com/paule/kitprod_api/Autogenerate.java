//package com.paule.kitprod_api;
//
//import org.springframework.data.annotation.Transient;
//
//public class Autogenerate {
//
//    @Transient
//    public static final String SEQUENCE_NAME = "users_sequence";
//
//    public long generateSequence(String seqName) {
//        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
//                new Update().inc("seq",1), options().returnNew(true).upsert(true),
//                DatabaseSequence.class);
//        return !Objects.isNull(counter) ? counter.getSeq() : 1;
//    }
//
//}
