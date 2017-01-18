package eu.cloudwave.wp5.feedback.eclipse.performance.extension;

import java.util.Collections;
import java.util.List;

import eu.cloudwave.wp5.feedback.eclipse.performance.extension.processor.ast.AstRoot;
import eu.cloudwave.wp5.feedback.eclipse.performance.extension.visitor.PerformanceVisitor;

/**
 * The Plugin interface for Performace Plugins
 * These can realise a whole bunch of Szenarios like: 
 *   Injecting informations from measurements as Tags
 *   Makeing performance Predictions
 *   Marking Elements to generate visual clues in Eclipse
 * @author Markus Knecht
 *
 */
public interface PerformancePlugin {

	/**
	 * Gets the Id of the plugin to identify it
	 * @return the Id which is an String (normally similar to a package name)
	 */
	public String getId();
	
	/**
	 * Provides the tags generated by this plugin
	 * @return a list of generated tag types
	 */
	default List<String> getProvidedTags(){return Collections.emptyList();}
	
	/**
	 * Provides the tags needed by this plugin
	 * @return a list of needed tag types
	 */
	default List<String> getRequiredTags(){return Collections.emptyList();}
	
	/**
	 * Provides the tags desired by this plugin
	 * @return a list of desired tag types
	 */
	default List<String> getOptionalRequiredTags(){return Collections.emptyList();}
	
	/**
	 * Performs the predictions and data loading over the ast
	 * @param ast the current ast
	 */
	public void processPerformanceAst(final AstRoot newAst);
	
}
