# BRIEF - Design Mini Instagram

You are the architect. Design the high-level system, using the blocks from today.
Do not write code. Draw boxes and arrows, and write one line of reasoning per
choice. Work in pairs. You have twenty minutes.

## What it must do (functional requirements)

- A user can post a photo (an image plus a caption).
- A user can follow and unfollow other users.
- A user sees a feed: recent posts from the people they follow, newest first.
- A user can like and comment on a post.
- A user can search for other users and for hashtags.

## What the load looks like (non-functional)

- Massively read-heavy: people scroll far more often than they post.
- Photos are large; text and metadata are small.
- It must stay responsive as users grow from thousands to millions.

## The five decisions (answer each, with a reason)

1. DATA MODEL
   Which tables (or collections) do you keep? Which keys link them?
   What, if anything, do you deliberately duplicate (denormalize), and why?

2. THE FEED
   How is a user's feed produced?  Fan-out on write, fan-out on read, or a
   hybrid?  State the trade-off you are accepting, and where your choice breaks.

3. CACHING
   What do you cache, where does the cache sit, and when do you invalidate it?

4. ASYNC WORK
   What happens off the write path (not while the user waits)?  Over what
   event(s)?  Which parts of the system react to a new post?

5. PORTS / SEAMS
   Which boundaries are interfaces (ports) rather than direct calls?  Name one
   service you could split out later, and the port it would sit behind.

## Stretch questions (if you have time)

- Where do the photo bytes actually live, and how do users download them fast?
- Which features want strong consistency, and which are fine being eventually
  consistent?  (Think CAP.)
- How would you shard the database?  What query gets hard when you do?

When you have a draft for all five, open `REFERENCE.md`.
