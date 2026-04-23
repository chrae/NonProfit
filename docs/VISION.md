# Vision

## Product vision

Build a nonprofit operations platform that reduces administrative burden for charities while growing into a broader ecosystem that helps organizations, volunteers, donors, businesses, and partner agencies work together more easily.

This is not just a recordkeeping app. The long-term goal is a coordination platform for nonprofit work.

## Core idea

The platform starts as a practical internal operations app for nonprofits, then expands outward into a larger ecosystem.

Long term, the platform should help:
- nonprofits manage internal operations
- volunteers discover and support causes
- nonprofits help other nonprofits
- businesses and supermarkets route surplus goods to organizations that can use them
- organizations publish needs and opportunities
- people and groups find concrete ways to help

A useful framing is:

> Build the operating system for nonprofit cooperation.

## Three-part ecosystem

### 1. Nonprofit operations app
The first product focus.

An internal app for running day-to-day nonprofit work such as:
- volunteers
- community service participants
- labor and hour tracking
- inventory and distribution
- events and scheduling
- documents and forms
- inter-agency records
- reporting

This should reduce dependence on paper forms, scattered spreadsheets, and repetitive manual follow-up.

### 2. Volunteer-side app
A volunteer-facing app where people can:
- interact with nonprofits they support
- discover opportunities to help
- log hours, participation, and achievements
- maintain their volunteer history across multiple organizations
- search for other charities and causes to support

The volunteer-side app should eventually support both:
- **native organizations** that operate directly on the platform
- **external organizations** that keep their own systems but can still be supported through organization-specific guidance, integrations, workflows, or helper tools

The platform should not assume every charity will adopt it directly.

### 3. Public web portal
A web portal where nonprofits can publish:
- volunteer opportunities
- events
- requests for help
- program information
- ways to donate or get involved

Over time, this portal should feed opportunities into the volunteer-side app.

## Design principles

- Reduce administrative burden, not add to it
- Autogenerate forms and paperwork wherever possible
- Route forms and records automatically wherever possible
- Keep a human in the loop where correctness matters
- Make volunteer participation easier and more rewarding
- Make inter-agency cooperation easier, more trackable, and more routine
- Start with practical internal operations first, then expand outward
- Prefer workflows that are useful in real daily operations over abstract feature lists

## Inter-agency ecosystem

The platform should help nonprofits cooperate with each other instead of acting like isolated islands.

Examples:
- a food pantry receiving intake from Organization X
- Charity 1 helping Charity 2 with labor, materials, transportation, space, or funds
- supermarkets or stores donating older food or surplus inventory
- one organization posting a need that another organization can fulfill

The system should make cross-help easier by giving organizations tools to:
- identify partner organizations
- log incoming and outgoing support
- document what was given, received, or requested
- track fulfillment and follow-through
- build repeatable partnerships instead of improvising everything from scratch

## Inventory as a core capability

Inventory is not a side feature.

For pantry and distribution use cases, the platform should support:
- inventory tracking
- distribution workflows
- source tracking
- expiration awareness
- printable dynamic menus
- AI-assisted intake from photos

## AI-assisted intake

For inventory intake, staff should be able to take one or more pictures of an item and have AI propose useful metadata before saving the record.

Potential extracted fields include:
- item name
- category
- brand
- package type
- estimated quantity or unit count
- visible size or weight information
- expiration or best-by date if visible
- condition notes
- suggested pantry/menu label

This should be **assisted intake**, not blind automation:
- AI proposes
- staff reviews and corrects
- the approved data and image are saved together

## Adoption model

Universal adoption is not required.

The platform can still be valuable if only some nonprofits use it directly, as long as it also helps volunteers and organizations interact with major outside charities that keep their own systems.

## Near-term direction

The immediate focus is to build:
1. a tablet-first nonprofit operations app
2. a visible UI skeleton with placeholders for the broader system
3. a real working workflow for volunteer labor tracking, with first focus on community service hours
4. inventory tracking as the next major implemented feature area
