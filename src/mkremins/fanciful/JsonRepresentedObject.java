package mkremins.fanciful;

import java.io.IOException;

import com.google.gson.stream.JsonWriter;

/**
 * Represents an object that can be serialized to a JSON writer instance.
 */
interface JsonRepresentedObject {

	public void writeJson(JsonWriter writer) throws IOException;

}
