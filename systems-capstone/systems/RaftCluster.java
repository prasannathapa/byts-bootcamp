package systems;

import java.util.ArrayList;
import java.util.List;

/**
 * CP6 (boss) - simplified Raft leader election (no timeouts, threads, or logs).
 * Implement two things:
 *   - Node.requestVote: grant a vote only if the candidate's term is at least ours AND we have not
 *     already voted this term; step down (and clear our vote) when we see a higher term.
 *   - elect: the candidate bumps its term, votes for itself, asks every other node, and becomes
 *     leader only with a strict majority.
 */
public final class RaftCluster {

    public enum Role { FOLLOWER, CANDIDATE, LEADER }

    public static final class Node {
        final int id;
        int term = 0;
        Integer votedFor = null;
        Role role = Role.FOLLOWER;

        Node(int id) { this.id = id; }

        boolean requestVote(int candidateTerm, int candidateId) {
            // TODO: reject if candidateTerm < term. If candidateTerm > term, adopt it, clear votedFor,
            //       become FOLLOWER. Then grant (and record votedFor) only if we haven't voted for
            //       someone else this term.
            throw new UnsupportedOperationException("TODO: implement requestVote");
        }
    }

    private final List<Node> nodes = new ArrayList<>();

    public RaftCluster(int size) {
        if (size <= 0) throw new IllegalArgumentException("size must be positive");
        for (int i = 0; i < size; i++) nodes.add(new Node(i));
    }

    public Node node(int id) { return nodes.get(id); }

    public int elect(int candidateId) {
        // TODO: bump the candidate's term, become CANDIDATE, vote for self (1 vote); ask every other
        //       node with requestVote(term, id); if votes > size/2, become LEADER and return id;
        //       otherwise become FOLLOWER and return -1
        throw new UnsupportedOperationException("TODO: implement elect");
    }
}
