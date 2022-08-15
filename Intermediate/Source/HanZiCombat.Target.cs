using UnrealBuildTool;

public class HanZiCombatTarget : TargetRules
{
	public HanZiCombatTarget(TargetInfo Target) : base(Target)
	{
		Type = TargetType.Game;
		ExtraModuleNames.Add("HanZiCombat");
	}
}
