package eu.cloudwave.wp5.feedback.eclipse.performance.extension.processor.ast;

import java.util.List;
import java.util.stream.Collectors;

import eu.cloudwave.wp5.feedback.eclipse.performance.extension.AstContext;

public class Try extends AAstNode<org.eclipse.jdt.core.dom.TryStatement> {
	
	Try(org.eclipse.jdt.core.dom.TryStatement tryStat, AstContext ctx) {
		super(tryStat,ctx);
	}
	
	public Block getBody(){
		return StaticAstFactory.createBlock(inner.getBody(),ctx);
	}
	
	@SuppressWarnings("unchecked")
	public List<CatchClause> getCactchClauses(){
		return ((List<org.eclipse.jdt.core.dom.CatchClause>)inner.catchClauses()).stream().map(b ->  StaticAstFactory.createCatchClause(b,ctx)).collect(Collectors.toList());
	}

	public Block getFinally(){
		if(inner.getFinally() == null) return null;
		return StaticAstFactory.createBlock(inner.getFinally(),ctx);
	}
}
