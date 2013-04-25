package com.hpcloud.maas.infrastructure.thresholding;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import backtype.storm.tuple.Fields;

import com.hpcloud.maas.infrastructure.storm.TupleDeserializer;
import com.hpcloud.util.Serialization;

/**
 * Deserializes MaaS events using registered serialization types.
 * 
 * <ul>
 * <li>Output: Object event
 * </ul>
 * 
 * @author Jonathan Halterman
 */
public class MaasEventDeserializer implements TupleDeserializer, Serializable {
  private static final long serialVersionUID = -1306620481933667305L;
  private static final Fields FIELDS = new Fields("event");

  @Override
  public List<List<?>> deserialize(String tuple) {
    return Collections.<List<?>>singletonList(Collections.singletonList(Serialization.fromJson(tuple)));
  }

  @Override
  public Fields getOutputFields() {
    return FIELDS;
  }
}
